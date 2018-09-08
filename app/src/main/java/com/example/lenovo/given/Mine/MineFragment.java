package com.example.lenovo.given.Mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.lenovo.given.R;


public class MineFragment extends Fragment {

    private RelativeLayout RL1;
    private RelativeLayout RL2;
    private RelativeLayout RL3;
    private RelativeLayout RL4;
    private RelativeLayout RL5;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.activity_main_mine,container, false);
        //initview();
        view.findViewById(R.id.mine_item2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),MineRL1.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.mine_item3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),MineRL1.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.mine_item4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),MineRL1.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.mine_item5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),MineRL1.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.mine_item6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),MineRL1.class);
                startActivity(intent);
            }
        });
        /*
        //记得在XML里设置android:focusable="true"/n  android:clickable="true"/n  android:onClick="onClick"
        //仍然空？？？？设置了上述XML以后，必定有点击反应。
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                switch (v.getId()){
                    case R.id.mine_item2:
                        intent.setClass(getActivity(),MineRL1.class);
                        startActivity(intent);
                        break;
                    case R.id.mine_item3:
                        intent.setClass(getActivity(),MineRL1.class);
                        startActivity(intent);
                        break;
                    case R.id.mine_item4:
                        intent.setClass(getActivity(),MineRL1.class);
                        startActivity(intent);
                        break;
                    case R.id.mine_item5:
                        intent.setClass(getActivity(),MineRL1.class);
                        startActivity(intent);
                        break;
                    case R.id.mine_item6:
                        intent.setClass(getActivity(),MineRL1.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });*/
        return view;
    }

    /*
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
    */
/*
    private void initview() {
    // 空指针！？？？？尝试对空对象引用调用虚拟方法。
    //java.lang.NullPointerException: Attempt to invoke virtual method 'android.view.View android.view.View.findViewById(int)' on a null object reference
        RL1 = RL1.findViewById(R.id.mine_item2);
        RL2 = RL2.findViewById(R.id.mine_item3);
        RL3 = RL3.findViewById(R.id.mine_item4);
        RL4 = RL4.findViewById(R.id.mine_item5);
        RL5 = RL5.findViewById(R.id.mine_item6);

        RL1.setOnClickListener((View.OnClickListener) this);
        RL2.setOnClickListener((View.OnClickListener) this);
        RL3.setOnClickListener((View.OnClickListener) this);
        RL4.setOnClickListener((View.OnClickListener) this);
        RL5.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View view){
        Intent intent=new Intent();
        switch (view.getId()){
            case R.id.mine_item2:
                intent.setClass(getActivity(),MineRL1.class);
                startActivity(intent);
                break;
            case R.id.mine_item3:
                intent.setClass(getActivity(),MineRL1.class);
                startActivity(intent);
                break;
            case R.id.mine_item4:
                intent.setClass(getActivity(),MineRL1.class);
                startActivity(intent);
                break;
            case R.id.mine_item5:
                intent.setClass(getActivity(),MineRL1.class);
                startActivity(intent);
                break;
            case R.id.mine_item6:
                intent.setClass(getActivity(),MineRL1.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

*/

}
