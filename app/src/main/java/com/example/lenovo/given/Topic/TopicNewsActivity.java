package com.example.lenovo.given.Topic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.given.Home.HomeNewsActivity;
import com.example.lenovo.given.MainActivity;
import com.example.lenovo.given.R;

public class TopicNewsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_news);
        initView();
    }

    private void initView() {
        Button backtitlebutton3=findViewById(R.id.back_title_button3);
        backtitlebutton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(TopicNewsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
