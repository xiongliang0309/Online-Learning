package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Chapter {
    private String chapterid;
    private String chaptername;
    private String kechenid;
    private Boolean isupload;
    private String teachername;

    public Chapter() {
        super();
    }

    public String getChapterid() {
        return chapterid;
    }

    public void setChapterid(String chapterid) {
        this.chapterid = chapterid;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public String getKechenid() {
        return kechenid;
    }

    public void setKechenid(String kechenid) {
        this.kechenid = kechenid;
    }

    public Boolean getIsupload() {
        return isupload;
    }

    public void setIsupload(Boolean isupload) {
        this.isupload = isupload;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterid='" + chapterid + '\'' +
                ", chaptername='" + chaptername + '\'' +
                ", kechenid='" + kechenid + '\'' +
                ", isupload='" + isupload + '\'' +
                ", teachername='" + teachername + '\'' +
                '}';
    }
}
