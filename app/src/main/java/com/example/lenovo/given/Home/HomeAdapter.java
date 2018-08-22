package com.example.lenovo.given.Home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.given.R;

import java.util.List;

public class HomeAdapter extends BaseAdapter implements View.OnClickListener{

/*  关于BaseAdapter：
    系统在绘制ListView之前，将会先调用getCount方法来获取Item的个数。
    每绘制一个Item就会调用一次getView方法，
    在getView中引用事先定义好的layout布局确定显示的效果并返回一个View对象作为一个Item显示出来。
    这两个方法是自定ListView显示效果中最为重要的，
    同时只要重写好了这两个方法，ListView就能完全按开发者的要求显示。
    而getItem和getItemId方法将会在调用ListView的响应方法的时候被调用到。
*/

    private List<HomeItem> homeItemList;
    private Context mContext;
    private LayoutInflater mInflater;
    private HomeClickListener mListener;//所有listview的item共用同一个。
    private int resoureId;

    //定义回调接口，用于回调按钮点击事件到Activity。
    //关于item中包含点击事件，用回掉接口，来实现拍照按钮，数据提交按钮等。
    public interface HomeClickListener{
        //listView item下的控件点击事件（注意传入参数V）。
        public void clickListener(View v);
    }

    //定义接口方法。？
    @Override
    public void onClick(View v) {
        //在onClick中回调接口的 clickListener。
        mListener.clickListener(v);
    }

    private class ViewHolder{
        private ImageView imageView;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
    }

    public HomeAdapter(Context context,int textViewResourceId,List<HomeItem> homeItemList,HomeClickListener listener){
        mContext=context;
        this.homeItemList=homeItemList;
        mListener= listener;
        mInflater = LayoutInflater.from(context);
        this.resoureId=textViewResourceId;
    }

    @Override
    public int getCount() {
        return homeItemList.size();
    }
    //在此适配器中所代表的数据集中的条目数。

    @Override
    public Object getItem(int position) {
        return homeItemList.get(position);
    }
    //获取数据集中与指定索引对应的数据项。

    @Override
    public long getItemId(int position) {
        return position;
    }
    //取在列表中与指定索引对应的行id。

    @Override
    public View getView( int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            //加载布局为一个视图。
            viewHolder=new ViewHolder();//******这个地方去掉程序崩溃？root的问题也要解决？*******
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_main_home_item1, null) ;
            viewHolder.imageView = convertView.findViewById(R.id.home_item1_name_image);
            viewHolder.tv1= convertView.findViewById(R.id.home_item1_date_text);
            viewHolder.tv2= convertView.findViewById(R.id.home_item1_title_text);
            viewHolder.tv3= convertView.findViewById(R.id.home_item1_content_text);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        //***如果没有这些内容，将会显示布局文件中的内容。***
        viewHolder.tv1.setText(homeItemList.get(position).getDate());
        viewHolder.tv2.setText(homeItemList.get(position).getTitle());
        viewHolder.tv3.setText(homeItemList.get(position).getContent());
        viewHolder.imageView.setImageResource(R.drawable.home_news_2);
        //设置内部控件的点击事件。
        //viewHolder.tv3.setOnClickListener(this);
/*
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this,HomeNewsActivity.class);

            }
        });
*/
        return convertView;
    }

 /*   static class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView info;
    }
*/


}


/*
利用BaseAdapter实现一个ListView的步骤一般如下：
1 首先准备好需要显示在LiseView中的数据 ——List
2 然后编写2 个XML 文件 第一个文件是ListView控件所在的布局文件 第二个文件是ListVIew中每一个item的布局文件
3 创建一个继承自BaseAdapter的类
4 为ListView绑定适配器 setAdapter（继承BaseAdapter 类的实例）
5 用传统方式来覆写适配器的getView函数和getCount 函数（从参数convertView里映射布局文件，find各个控件填充数据）
6 加入ViewHolder类（定义n个控件的声明）用convertView.setTag（viewHolder）在View和Object之间关联,此目的是节省find多次的时间。
 */

/*
    extends ArrayAdapter<HomeItem>支持泛型操作，最简单的一个Adapter，只能展现一行文字！！！！
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
*/

