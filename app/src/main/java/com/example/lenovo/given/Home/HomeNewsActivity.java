package com.example.lenovo.given.Home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.given.MainActivity;
import com.example.lenovo.given.R;
import com.example.lenovo.given.SearcherActivity;

public class HomeNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        initView();
    }

    private void initView() {
        Button backtitlebutton3=findViewById(R.id.back_title_button3);
        backtitlebutton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(HomeNewsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
