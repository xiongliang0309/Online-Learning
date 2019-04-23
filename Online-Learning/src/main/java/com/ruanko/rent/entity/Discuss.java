package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Discuss {
    private String discussid;
    private String discusstitle;
    private String discusscontent;
    private String discussdate;
    private String discusser;


    public Discuss() {
        super();
    }

    public String getDiscussid() {
        return discussid;
    }

    public void setDiscussid(String discussid) {
        this.discussid = discussid;
    }

    public String getDiscusstitle() {
        return discusstitle;
    }

    public void setDiscusstitle(String discusstitle) {
        this.discusstitle = discusstitle;
    }

    public String getDiscusscontent() {
        return discusscontent;
    }

    public void setDiscusscontent(String discusscontent) {
        this.discusscontent = discusscontent;
    }

    public String getDiscussdate() {
        return discussdate;
    }

    public void setDiscussdate(String discussdate) {
        this.discussdate = discussdate;
    }

    public String getDiscusser() {
        return discusser;
    }

    public void setDiscusser(String discusser) {
        this.discusser = discusser;
    }


    @Override
    public String toString() {
        return "Discuss{" +
                "discussid='" + discussid + '\'' +
                ", discusstitle='" + discusstitle + '\'' +
                ", discusscontent='" + discusscontent + '\'' +
                ", discussdate='" + discussdate + '\'' +
                ", discusser='" + discusser + '\'' +
                '}';
    }
}
