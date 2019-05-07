package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component

public class Notice {

    private String id;
    private String title;
    private String content;
    private String noticer;
    private String noticedate;
    private String classid;

    public Notice() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getNoticer() {
        return noticer;
    }

    public void setNoticer(String noticer) {
        this.noticer = noticer;
    }

    public String getNoticedate() {
        return noticedate;
    }

    public void setNoticedate(String noticedate) {
        this.noticedate = noticedate;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", noticer='" + noticer + '\'' +
                ", noticedate='" + noticedate + '\'' +
                ", classid='" + classid + '\'' +
                '}';
    }
}
