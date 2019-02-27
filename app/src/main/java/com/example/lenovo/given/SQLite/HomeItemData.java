package com.example.lenovo.given.SQLite;

/**
 * Created by TK on 2018/12/4.
 */


public class HomeItemData {
//HomeItemData 实体类

    public static final String TABLE="HomeItemData";

    private int home_ID;
    private String hometitle;
    private String homecontent;
    private String homedata;

    public int getHome_ID() {
        return home_ID;
    }

    public void setHome_ID(int home_ID) {
        this.home_ID = home_ID;
    }

    public String getHometitle() {
        return hometitle;
    }

    public void setHometitle(String hometitle) {
        this.hometitle = hometitle;
    }

    public String getHomecontent() {
        return homecontent;
    }

    public void setHomecontent(String homecontent) {
        this.homecontent = homecontent;
    }

    public String getHomedata() {
        return homedata;
    }

    public void setHomedata(String homedata) {
        this.homedata = homedata;
    }
}

