package com.example.lenovo.given.Home;

////每一个字段对应的表中的每一列。建立主页我们自己推送的home item的类，用于建表。
public class HomeItem {
    private int homeimage;
    private String title;
    private String content;
    private String date;

    public HomeItem(String title,String content,int homeimage,String date){
        this.content=content;
        this.date=date;
        this.homeimage=homeimage;
        this.title=title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHomeimage() {
        return homeimage;
    }

    public void setHomeimage(int homeimage) {
        this.homeimage = homeimage;
    }
}
