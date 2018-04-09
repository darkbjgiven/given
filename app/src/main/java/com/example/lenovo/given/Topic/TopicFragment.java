package com.example.lenovo.given.Topic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.given.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TopicFragment extends Fragment {
    private List<Topic> TopicItemList=new ArrayList<>();
    private Topic[] topics={
        new Topic(R.drawable.picture_1,"firsttopic","ahaaaaaaaaaaaaaaaaaaaaaaaaaa"),
        new Topic(R.drawable.picture_2,"secondtopic","wbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"),
        new Topic(R.drawable.picture_3,"thirdtopic","rcccccccccccccccccccc"),
        new Topic(R.drawable.picture_4,"forthtopic","idddddddddddddddddddddddddd"),
        new Topic(R.drawable.picture_5,"fifthtopic","leeeeeeeeeeeeee")
    };
    private TopicAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.activity_main_topic,container, false);
        initTopics();
        RecyclerView recyclerView=view.findViewById(R.id.topic_recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this.getContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new TopicAdapter(TopicItemList);
        recyclerView.setAdapter(adapter);
        return view;//return语句一定要写在最后面。
    }

    private void initTopics() {
        TopicItemList.clear();
        for (int i=0;i<30;i++){
            Random random=new Random();
            int index=random.nextInt(topics.length);
            TopicItemList.add(topics[index]);
        }
    }
}
