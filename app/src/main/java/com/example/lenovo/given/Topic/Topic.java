package com.example.lenovo.given.Topic;

public class Topic {
    private int topicimage;
    private String topictexttitle;
    private String topictextarticle;

    public Topic(int topicimage,String topictexttitle,String topictextarticle){
        this.topicimage=topicimage;
        this.topictexttitle=topictexttitle;
        this.topictextarticle=topictextarticle;
    }

    public int getTopicimage() {
        return topicimage;
    }

    public String getTopictexttitle() {
        return topictexttitle;
    }

    public String getTopictextarticle() {
        return topictextarticle;
    }
}
