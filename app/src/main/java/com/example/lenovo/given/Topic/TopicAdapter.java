package com.example.lenovo.given.Topic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.given.MainActivity;
import com.example.lenovo.given.R;

import java.util.List;


public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {
    private Context mContext;
    private List<Topic> TopicItemList;//Topic类的List。

    //TopicAdapter（）的构造器，添加item。
    public TopicAdapter(List<Topic> TopicItemList){
        //this.mContext=Context;
        this.TopicItemList=TopicItemList;

    }

    //自定义ViewHolder类。
    static class ViewHolder extends RecyclerView.ViewHolder  {
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

    //创建视图并且返回一个匹配的viewholder。
     @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.activity_main_topic_item,parent,false);
        //点击事件都是在Adapter中由View自己注册的。

         /**
        holder.setOnClickListener(new View.OnClickListener() {

        });
        */
        return new ViewHolder(view);
    }

    //用每个item数据来填充viewholder。
    //用于对recycler view的子项赋值。
    // 在滚动到屏幕的时候执行。用position参数得到当前的topic实例。然后设置数据到view holder的各个图文里。
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        Topic topic=TopicItemList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //触发自定义监听的单击事件
                Intent intent=new Intent();
                intent.setClass(mContext,TopicNewsActivity.class);
                mContext.startActivity(intent);
                Toast.makeText(mContext,"点击事件",Toast.LENGTH_LONG).show();
                //onItemClickListener.onItemClick(holder.itemView,position);

            }
        });
/**

                onItemClickListener.onItemClick(holder.itemView,position);
*/
        holder.topicimage.setImageResource(topic.getTopicimage());
        holder.topictexrtitle.setText(topic.getTopictexttitle());
        holder.topictextarticle.setText(topic.getTopictextarticle());
    }
/**
    private TopicAdapter.OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(TopicAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    //自定义监听回调，RecyclerView 的 单击和长按事件。
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
*/
    //返回item的数目。
    //告诉recyclerview有多少个子项，返回数据长度。
    @Override
    public int getItemCount(){
        return TopicItemList.size();
    }


}


