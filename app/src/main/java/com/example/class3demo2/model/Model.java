package com.example.class3demo2.model;

import com.example.class3demo2.MyApplication;

import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model(){
    }

    public interface GetAllTeachersListener {
        void onComplete(List<Teacher> data);
    }
    public void getAllTeachers(GetAllTeachersListener listener){
        MyApplication.executorService.execute(()->{
            List<Teacher> data = AppLocalDB.db.teacherDao().getAll();
            MyApplication.mainHandler.post(()->{
                listener.onComplete(data);
            });
        });
    }

    public interface AddTeacherListener {
        void onComplete();
    }
    public void addTeacher(Teacher teacher, AddTeacherListener listener){
        MyApplication.executorService.execute(()->{
            AppLocalDB.db.teacherDao().insertAll(teacher);
            MyApplication.mainHandler.post(()->{
                listener.onComplete();
            });
        });
    }

    public interface GetTeacherByIdListener {
        void onComplete(Teacher teacher);
    }
    public void getTeacherById(String teacherId, GetTeacherByIdListener listener) {
        MyApplication.executorService.execute(()->{
            Teacher teacher = AppLocalDB.db.teacherDao().getTeacherById(teacherId);
            MyApplication.mainHandler.post(()->{
                listener.onComplete(teacher);
            });
        });
    }
}
