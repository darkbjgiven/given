package com.example.lenovo.given.Topic;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.given.R;

import java.util.List;


public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {
    private Context mContext;
    private List<Topic> TopicItemList;//Topic类的List。

    public TopicAdapter(List<Topic> TopicItemList){
        //this.mContext=Context;
        this.TopicItemList=TopicItemList;

    }

    //自定义ViewHolder类。
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView topicimage;
        TextView topictexrtitle;
        TextView topictextarticle;

        ViewHolder(View view){
            super(view);
            cardView=(CardView) view;
            topicimage= view.findViewById(R.id.topic_image);
            topictexrtitle= view.findViewById(R.id.topic_text_title);
            topictextarticle= view.findViewById(R.id.topic_text_article);
        }
    }

    //创建view holder实例。并把加载出来的布局传入到构造函数中，最后用view holder的实例返回。
    /**关于LayoutInflater.from的注释：
     * 从一个Context中，获得一个布局填充器，这样你就可以使用这个填充器来把xml布局文件转为View对象了。
     * //加载布局管理器
     LayoutInflater inflater = LayoutInflater.from(context);
     //将xml布局转换为view对象
     convertView = inflater.inflate(R.layout.item_myseallist,parent, false);
     //利用view对象，找到布局中的组件
     convertView.findViewById(R.id.delete);// 删除
     */
     @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.activity_main_topic_item,parent,false);
        return new ViewHolder(view);
    }

    //用于对recycler view的子项赋值。
    // 在滚动到屏幕的时候执行。用position参数得到当前的topic实例。然后设置数据到view holder的各个图文里。
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Topic topic=TopicItemList.get(position);
        holder.topicimage.setImageResource(topic.getTopicimage());
        holder.topictexrtitle.setText(topic.getTopictexttitle());
        holder.topictextarticle.setText(topic.getTopictextarticle());
    }

    //告诉recyclerview有多少个子项，返回数据长度。
    @Override
    public int getItemCount(){
        return TopicItemList.size();
    }


}


