package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Choice {
    private String choiceid;
    private String choicetitle;
    private String choicea;
    private String choiceb;
    private String choicec;
    private String choiced;
    private String kechenid;
    private String chapterid;




    public Choice() {
        super();
    }

    public String getChoiceid() {
        return choiceid;
    }

    public void setChoiceid(String choiceid) {
        this.choiceid = choiceid;
    }

    public String getChoicetitle() {
        return choicetitle;
    }

    public void setChoicetitle(String choicetitle) {
        this.choicetitle = choicetitle;
    }

    public String getChoicea() {
        return choicea;
    }

    public void setChoicea(String choicea) {
        this.choicea = choicea;
    }

    public String getChoiceb() {
        return choiceb;
    }

    public void setChoiceb(String choiceb) {
        this.choiceb = choiceb;
    }

    public String getChoicec() {
        return choicec;
    }

    public void setChoicec(String choicec) {
        this.choicec = choicec;
    }

    public String getChoiced() {
        return choiced;
    }

    public void setChoiced(String choiced) {
        this.choiced = choiced;
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
        return "Choice{" +
                "choiceid='" + choiceid + '\'' +
                ", choicetitle='" + choicetitle + '\'' +
                ", choicea='" + choicea + '\'' +
                ", choiceb='" + choiceb + '\'' +
                ", choicec='" + choicec + '\'' +
                ", choiced='" + choiced + '\'' +
                ", chapterid='" + chapterid + '\'' +
                ", kechenid='" + kechenid + '\'' +
                '}';
    }
}
