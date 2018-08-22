package com.example.lenovo.given.LitePal;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.Date;

public class HomeItemDemo extends DataSupport {
    @Column(unique = true,defaultValue = "unknown")
    private int id;
    private String title;
    private String content;
    private Date publishdate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }


}
