package com.example.lenovo.given.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by TK on 2018/12/4.
 */


public class DataBaseHelper extends SQLiteOpenHelper {
//DataBaseHelper继承自SQLiteOpenHelper。

    private Context mContext;

    /*
    DataBaseHelper中：
    （Context 对数据库进行操作，
    数据库名字 创建数据库时使用这个名称，
    一般null 在查询数据时返回一个自定义的Cursor，
    当前数据库版本号，用于对数据库进行升级操作）
     */
    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE HomeIemData (" +
                "home_ID integer primary key autoincrement," +
                "hometitle text unique," +
                "homecontent text unique," +
                "homedata text unique);");
        //db.execSQL(CREATE_HOMEITEMDATA);//建表，而非数据库。
        Toast.makeText(mContext,"Create HomeItemData succeeded", Toast.LENGTH_SHORT).show();
        Log.d("TAG", "***********************已经创建好HomeItemData表********************** ");
        System.out.println("***********************已经创建好HomeItemData表********************** ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        switch (oldVersion){
            case 1:
                db.execSQL("drop table if exists HomeItemData ");
                onCreate(db);
            default:
        }


    }

}

