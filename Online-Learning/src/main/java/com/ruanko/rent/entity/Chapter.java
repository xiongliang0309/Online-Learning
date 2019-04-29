package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Chapter {
    private String chapterid;
    private String chaptername;
    private String kechenid;

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


    @Override
    public String toString() {
        return "Chapter{" +
                "chapterid='" + chapterid + '\'' +
                ", chaptername='" + chaptername + '\'' +
                ", kechenid='" + kechenid + '\'' +
                '}';
    }
}