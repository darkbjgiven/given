package com.example.lenovo.given.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TK on 2018/12/4.
 */


public class HomeDataOperator {
// HomeDataOperator 操作类。

    private DataBaseHelper dbHelper;
    //private SQLiteDatabase db;

    public HomeDataOperator(Context context){

        dbHelper =new DataBaseHelper(context,"HomeItemData.db",null,1);

    }

    public void Insert(HomeItemData homeItemData){
        SQLiteDatabase db=dbHelper.getWritableDatabase();

        //准备数据。
        ContentValues values=new ContentValues();
        values.put("hometitle",homeItemData.getHometitle());
        values.put("homecontent",homeItemData.getHomecontent());
        values.put("homedata",homeItemData.getHomedata());

        //通过ContentValues中的数据拼接SQL语句,执行插入操作,id为表中的一个列名。
        db.insert("HomeItemData","home_ID",values);
        db.close();
    }

    public void delete(int home_ID){
        SQLiteDatabase db=dbHelper.getWritableDatabase();

        //执行删除操作,在person表中删除id为指定值的记录。
        db.delete("HomeItemData","home_ID=?",new String[]{String.valueOf(home_ID)});
        db.close();
    }

    public void update(HomeItemData homeItemData){
        SQLiteDatabase db=dbHelper.getWritableDatabase();

        //要更新的数据。
        ContentValues values=new ContentValues();
        values.put("hometitle",homeItemData.getHometitle());
        values.put("Homecontent",homeItemData.getHomecontent());
        values.put("Homedata",homeItemData.getHomedata());

        //更新person表中id为指定值的记录。
        db.update("HomeItemData",values,"Home_ID=?",new String[]{String.valueOf(homeItemData.getHome_ID())});

        db.close();
    }

    public HomeItemData query(int Home_ID){
        SQLiteDatabase db=dbHelper.getWritableDatabase();

        //用游标Cursor接收从数据库检索到的数据。
        Cursor cursor=db.query(false,"HomeItemData",new String[]{"hometitle","Homecontent","Homedata"},
                "Home_ID=?",
                new String[]{String.valueOf(Home_ID)},null,null,null,null);
        //判断游标是否为空。
        HomeItemData homeItemData=null;
        //判断Cursor是否有下一条记录。
        //依次取出数据。
        if (cursor.moveToFirst()){
            homeItemData =new HomeItemData();
            homeItemData.setHome_ID(cursor.getInt(cursor.getColumnIndex("home_ID")));
            homeItemData.setHometitle(cursor.getString(cursor.getColumnIndex("hometitle")));
            homeItemData.setHomecontent(cursor.getString(cursor.getColumnIndex("homecontent")));
            homeItemData.setHomedata(cursor.getString(cursor.getColumnIndex("homedata")));
        }
        //释放资源。
        cursor.close();
        db.close();
        return homeItemData;

    }

    public List<HomeItemData> findAll(){
        //查询所有记录。
        List<HomeItemData> lists=new ArrayList<HomeItemData>();
        HomeItemData homeItemData=null;
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        //rawQuery()方法的第一个参数为select语句；第二个参数为select语句中占位符参数的值。
        Cursor cursor=db.rawQuery("select * from HomeItemData",null);
        while (cursor.moveToNext()){
            homeItemData=new HomeItemData();
            homeItemData.setHome_ID(cursor.getInt(cursor.getColumnIndex("home_ID")));
            homeItemData.setHometitle(cursor.getString(cursor.getColumnIndex("hometitle")));
            homeItemData.setHomecontent(cursor.getString(cursor.getColumnIndex("homecontent")));
            homeItemData.setHomedata(cursor.getString(cursor.getColumnIndex("homedata")));
            lists.add(homeItemData);

        }

        db.close();
        return lists;

    }

}
