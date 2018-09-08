package com.example.lenovo.given.Topic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
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
        new Topic(R.drawable.picture_1,"西电健康饮食","良好合理的健康饮食习惯是保健的一个重要方面，可使身体健康地生长、发育；不良的饮食习惯则会导致人体正常的生理功能紊乱而感染疾病。相反，恰当的饮食对疾病会起到治疗的作用，帮助人体恢复健康。在当今社会，已成为一个很热门的话题。"),
        new Topic(R.drawable.picture_2,"关于运动的那些事","体育运动是增进身体健康、改善体质的主要手段。但是体育锻炼必须遵循人体运动时的生理变化规律，并充分注意营养、休息、安全和卫生等，否则会造成不良影响，妨碍身体健康，甚至造成严重危害，留下终身痛苦。"),
        new Topic(R.drawable.picture_3,"游泳馆游泳需知","游泳深受广大民众所喜爱，十分有助于我们的健康，而且还有减肥的作用，但是也要注意其带给我们的不良的影响，因此，我们养成良好的游泳习惯，避免以下不良的习惯"),
        new Topic(R.drawable.picture_4,"西电自拍地点推荐","手机自拍是手机社交里最有趣的一部分了，我们会给大家推荐些西电的自拍地点，让大家可以给身边的人展示西电人优美的校园生活"),
        new Topic(R.drawable.picture_5,"宠物出没！请注意！","在校大学生养宠物屡见不鲜，虽然不少学校明令禁止在宿舍饲养宠物，但仍然有不少同学因为喜爱而偷偷养宠物，每逢毕业季，总有一些宠物被主人抛弃，成为校园里的流浪动物。 ")
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
        /*
        //设置cardview的点击事件。
        CardView cardView= getView().findViewById(R.id.topic_cardview);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),TopicNewsActivity.class);
                startActivity(intent);
            }
        });
*/
    }
}
