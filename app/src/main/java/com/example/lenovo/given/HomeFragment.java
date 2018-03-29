package com.example.lenovo.given;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //创建Fragment的View对象。
        View view =inflater.inflate(R.layout.activity_main_home,container, false);
        return view;


    }


}