package com.example.lenovo.given.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lenovo.given.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements HomeAdapter.HomeClickListener{

    private List<HomeItem> homeItemList;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //创建Fragment的View对象。
        View view =inflater.inflate(R.layout.activity_main_home,container, false);
        initHomeItem();
        //HomeAdapter adapter=new HomeAdapter(getContext(),R.layout.activity_main_home_item1,homeItemList);
        listView=view.findViewById(R.id.listView);
        //****listview没有item的layout布局????*****或者是item的内容被点击什么的给覆盖了。
        //***检查逻辑问题***
        HomeAdapter homeAdapter = new HomeAdapter(getContext(),R.layout.activity_main_home_item1, homeItemList, this);
        //view=LayoutInflater.from(getContext()).inflate(R.layout.activity_main_home_item1,null);
        listView.setAdapter(homeAdapter);

        //点击item跳转到一个指定界面。
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),HomeNewsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void initHomeItem() {
            homeItemList=new ArrayList<>();
            HomeItem news1=new HomeItem(
                    "最全的国创资料都在这里了",
                    "全称国家大学生创新性实验计划。学生的创新实验能力国家大学生创新性实验计划是高等学校本科教学“质量工程”的重要组成部分，该计划的启动和实施，旨在探索并建立以问题和课题为核心的教学模式，倡导以本科学生为主体的创新性实验改革，调动学生的主动性、积极性和创造性，激发学生的创新思维和创新意识，在校园内形成创新教育氛围，建设创新教育文化。",
                    R.drawable.home_news_2,
                    "西电科协发布");
            homeItemList.add(news1);

            HomeItem news2=new HomeItem(
                    "留学申请，你应该知道的那些事儿",
                    "留学申请，都需要做哪些准备，什么时候做？这个问题看似简单，却困扰着很多同学和家长。暑期将至，为帮助同学和家长们抓住暑期时间，做好留学准备，世毕盟诚意推出留学申请公开课，全面解析留学申请中的常见问题！",
                    R.drawable.home_news_2,
                    "西电科协发布");
            homeItemList.add(news2);

            HomeItem news3=new HomeItem(
                    "最全的微软“创新杯”资料都在这里了",
                    "微软“创新杯”全球学生大赛是目前全球规模大、影响广的学生科技大赛。创始于2003年，旨在鼓励青年学生发挥想象和创新能力，投身科技创新事业。参赛者可使用相关工具和技术，展示自己的创意和技术，创建一流的科技解决方案。并为不同背景的学生提供了合作、创新的机会，以及将创意变为商业现实的平台。",
                    R.drawable.home_news_2,
                    "西电科协发布");
            homeItemList.add(news3);

            HomeItem news4=new HomeItem(
                    "微软Hackathon校园行",
                    "hackathon，是一个流传于hacker当中的新词汇，意为编程马拉松。编程马拉松的精髓在于：很多人，在一段特定的时间内，相聚在一起，以他们想要的方式，去做他们想做的事情。在这次的西安三校hackathon活动中，我们面向的对象是来自来自全陕西的在读学生，Hacker们或是提前组队，或是现场组队，以3-6人为单位，在24小时内，将创意落地为可以解决行业、用户实际问题的产品。记得在你的产品所应用的技术中加入微软的元素（WIN10系统及PPT等除外）",
                    R.drawable.home_news_2,
                    "西电科协发布");
            homeItemList.add(news4);

    }


    @Override
    public void clickListener(View v) {
        //Intent intent=new Intent(getActivity(),HomeNewsActivity.class);
        Toast.makeText(getActivity(),"回掉成功",Toast.LENGTH_SHORT).show();

    }
}

//第一个问题是list的private
//第二个问题是最后的点击事件控件ID