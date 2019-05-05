package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Program {
    private String programid;
    private String programcontent;
    private String kechenid;
    private String chapterid;


    public Program() {
        super();
    }


    public String getProgramid() {
        return programid;
    }

    public void setProgramid(String programid) {
        this.programid = programid;
    }

    public String getProgramcontent() {
        return programcontent;
    }

    public void setProgramcontent(String programcontent) {
        this.programcontent = programcontent;
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
        return "Program{" +
                "programid='" + programid + '\'' +
                ", programcontent='" + programcontent + '\'' +
                ", kechenid='" + kechenid + '\'' +
                ", chapterid='" + chapterid + '\'' +
                '}';
    }
}
