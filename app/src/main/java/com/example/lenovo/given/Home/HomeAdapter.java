package com.example.lenovo.given.Home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.given.R;

import java.util.List;

public class HomeAdapter extends ArrayAdapter<HomeItem> {
    //项布局id。
    private int resoureId;
    public HomeAdapter(Context context,int textViewResourceId,List<HomeItem> homeItemList){
        super(context,textViewResourceId,homeItemList);
        this.resoureId=textViewResourceId;
    }

    //resource为listView的每个子项的布局id。
    //getView为listView的每个子项的布局设置内容。  
    //convertView用于将之前加载好的布局进行缓存。 
    //设置一个viewHolder对控件进行缓存。
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        HomeItem homeItem=getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resoureId,parent,false);
        ImageView homeitem1nameimage=view.findViewById(R.id.home_item1_name_image);
        TextView homeitem1datetext=view.findViewById(R.id.home_item1_date_text);
        TextView homeitem1titletext=view.findViewById(R.id.home_item1_title_text);
        TextView homeitem1contenttext=view.findViewById(R.id.home_item1_content_text);

        homeitem1nameimage.setImageResource(homeItem.getHomeimage());
        homeitem1datetext.setText(homeItem.getDate());
        homeitem1titletext.setText(homeItem.getTitle());
        homeitem1contenttext.setText(homeItem.getContent());
        return view;
    }
}
