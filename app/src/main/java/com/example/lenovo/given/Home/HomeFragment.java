package com.example.lenovo.given.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lenovo.given.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private List<HomeItem> homeItemList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //创建Fragment的View对象。
        View view =inflater.inflate(R.layout.activity_main_home,container, false);
        initHomeItem();
        HomeAdapter adapter=new HomeAdapter(getContext(),R.layout.activity_main_home_item1,homeItemList);
        ListView listView=view.findViewById(R.id.main_home_list);
        listView.setAdapter(adapter);
        return view;
    }

    private void initHomeItem() {
        for (int i=0;i<10;i++){
            HomeItem firstitem=new HomeItem("firstitem","aaaaaaaaaaaaaaaaaaaaaaaaaa",R.drawable.picture_1,"given发布于40分钟前");
            homeItemList.add(firstitem);
            HomeItem seconditem=new HomeItem("seconditem","bbbbbbbbbbbbbbbbbbbbbbbbbbb",R.drawable.picture_2,"mark发布于30分钟前");
            homeItemList.add(seconditem);
            HomeItem thirditem=new HomeItem("thirditem","ccccccccccccccccccccccccccccc",R.drawable.picture_3,"carlos发布于20分钟前");
            homeItemList.add(thirditem);
        }
    }


}