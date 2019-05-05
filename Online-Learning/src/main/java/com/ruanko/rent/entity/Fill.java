package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Fill {
    private String fillid;
    private String fillcontent;
    private String kechenid;
    private String chapterid;


    public Fill() {
        super();
    }


    public String getFillid() {
        return fillid;
    }

    public void setFillid(String fillid) {
        this.fillid = fillid;
    }

    public String getFillcontent() {
        return fillcontent;
    }

    public void setFillcontent(String fillcontent) {
        this.fillcontent = fillcontent;
    }

    public String getKechenid() {
        return kechenid;
    }

    public void setKechenid(String kechenid) {
        this.kechenid = kechenid;
    }

    public String getChapterid() {
        return chapterid;
    }

    public void setChapterid(String chapterid) {
        this.chapterid = chapterid;
    }

    @Override
    public String toString() {
        return "Fill{" +
                "fillid='" + fillid + '\'' +
                ", fillcontent='" + fillcontent + '\'' +
                ", kechenid='" + kechenid + '\'' +
                ", chapterid='" + chapterid + '\'' +
                '}';
    }
}
