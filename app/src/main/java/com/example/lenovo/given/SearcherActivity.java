package com.example.lenovo.given;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class SearcherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searcher);
        initView();
    }

    private void initView() {
        Button searcherbutton1 = findViewById(R.id.searcher_button1);
        searcherbutton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(SearcherActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}