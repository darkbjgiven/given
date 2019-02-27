package com.example.lenovo.given;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.given.Home.HomeFragment;
import com.example.lenovo.given.LitePal.HomeItemDemo;
import com.example.lenovo.given.Mine.MineFragment;
import com.example.lenovo.given.SQLite.DataBaseHelper;
import com.example.lenovo.given.Topic.TopicFragment;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 初始化顶部栏显示。
    private TextView maintitletext;
    private Button maintitlebutton1;
    private Button maintitlebutton2;

    // 定义Fragment对象。
    private HomeFragment homefragment;
    private TopicFragment topicfragment;
    private MineFragment minefragment;

    // 帧布局对象，用来存放Fragment对象。
    private FrameLayout mainframeLayout;

    //定义各控件。
    private TextView navigationhome;
    private TextView navigationtopic;
    private TextView navigationmine;

    // 定义FragmentManager对象管理器。
    private FragmentManager fragmentManager;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LitePal.getDatabase();
        //LitePal.initialize(this);

        fragmentManager=getSupportFragmentManager();//获取fragment管理器。
        initView();// 初始化界面控件。
        navigationhome.performClick(); // 初始化页面加载时显示第一个选项卡。
    }

    //初始化页面。并且对按钮添加点击事件。
    private void initView(){
        //初始化标题栏。
        maintitletext=findViewById(R.id.main_title_text);
        maintitlebutton1=findViewById(R.id.main_title_button1);
        maintitlebutton2=findViewById(R.id.main_title_button2);

        //对标题栏的2个Button设置点击事件。
        maintitlebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,SearcherActivity.class);
                startActivity(intent);
            }
        });

        //framlayout获取。
        mainframeLayout=findViewById(R.id.main_frame_container);

        navigationhome=findViewById(R.id.navigation_home);
        navigationhome.setOnClickListener(this);

        navigationtopic=findViewById(R.id.navigation_topic);
        navigationtopic.setOnClickListener(this);

        navigationmine=findViewById(R.id.navigation_mine);
        navigationmine.setOnClickListener(this);

        /*
        HomeItemDemo homeItemDemo=new HomeItemDemo();
        homeItemDemo.setTitle("第一个标题");
        homeItemDemo.setContent("第一篇文章");
        homeItemDemo.setId(1);
        homeItemDemo.setPublishdate(null);
        homeItemDemo.save();//此处存储失败，用save throws检查异常。
        if (homeItemDemo.save()){
            Toast.makeText(this,"建立成功",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"存储失败",Toast.LENGTH_SHORT).show();
        }
        */

        //主活动oncreate里：
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this, "HomeData.db", null, 1);
        db=dataBaseHelper.getWritableDatabase();

    }

    //重写onclick,设置选择菜单item的点击方法。
    @Override
    public void onClick(View view){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        hideFragments(fragmentTransaction);
        switch (view.getId()){
            case R.id.navigation_home:
                setSelected();
                navigationhome.setSelected(true);
                if (homefragment==null){
                    homefragment=new HomeFragment();
                    fragmentTransaction.add(R.id.main_frame_container,homefragment);
                }else {
                    //如果不为空，则直接将它显示出来。
                    fragmentTransaction.show(homefragment);
                }
                break;
            case R.id.navigation_topic:
                setSelected();
                navigationtopic.setSelected(true);
                if (topicfragment==null){
                    topicfragment=new TopicFragment();
                    fragmentTransaction.add(R.id.main_frame_container,topicfragment);
                }else {
                    fragmentTransaction.show(topicfragment);
                }
                break;
            case R.id.navigation_mine:
                setSelected();
                navigationmine.setSelected(true);
                if (minefragment==null){
                    minefragment=new MineFragment();
                    fragmentTransaction.add(R.id.main_frame_container,minefragment);
                }else {
                    fragmentTransaction.show(minefragment);
                }
                break;
        }
        fragmentTransaction.commit();//提交处理。
    }


    //设置选项菜单点击方法setChoiceItem的事件处理。
    private void setSelected(){
        navigationhome.setSelected(false);
        navigationtopic.setSelected(false);
        navigationmine.setSelected(false);

    }

    //当选中其中一个菜单时，隐藏其他Fragment
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (homefragment !=null){
            fragmentTransaction.hide(homefragment);
        }
        if (topicfragment !=null){
            fragmentTransaction.hide(topicfragment);
        }
        if (minefragment !=null){
            fragmentTransaction.hide(minefragment);
        }
    }

    /**
     *  选中TextView后对对应的Fragment进行判空，如果为空，初始化，并添加到容器中；
     *  而hide的话，我们定义一个方法hide所有的Fragment，每次触发点击事件就先调用这个hideAll方法，
     *  讲所有Fragment隐藏起来，然后如果TextView对应的Fragment不为空，我们就将这个Fragment显示出来；
这个我们通过点击事件来实现，点击TextView后先重置所有TextView的选中状态为false，
     然后设置点击的 TextView的选中状态为true；
这个更简单，我们是通过点击事件来设置选中的，那么在onCreate()方法里加个触发点击事件的方法.
     */

}
