package com.example.class3demo2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstPageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_first_page, container, false);
        // Inflate the layout for this fragment
        Button sub_teacher=view.findViewById(R.id.subTeacher);
        sub_teacher.setOnClickListener(Navigation.createNavigateOnClickListener(FirstPageFragmentDirections.actionFirstPageFragmentToLogInFragment()));

        Button search_btn = view.findViewById(R.id.cancel_bt);
        search_btn.setOnClickListener(Navigation.createNavigateOnClickListener(FirstPageFragmentDirections.actionGlobalSearchFragment()));




        return view;
    }
}