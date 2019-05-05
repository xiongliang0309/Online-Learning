package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Homework {
    private String studentid;
    private String studentname;
    private String chapterid;
    private String kechenid;
    private String answercontent;
    private String answerfile;
    private String score;
    private String classid;
    private String commitdate;




    public Homework() {
        super();
    }


    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getChapterid() {
        return chapterid;
    }

    public void setChapterid(String chapterid) {
        this.chapterid = chapterid;
    }

    public String getKechenid() {
        return kechenid;
    }

    public void setKechenid(String kechenid) {
        this.kechenid = kechenid;
    }

    public String getAnswercontent() {
        return answercontent;
    }

    public void setAnswercontent(String answercontent) {
        this.answercontent = answercontent;
    }

    public String getAnswerfile() {
        return answerfile;
    }

    public void setAnswerfile(String answerfile) {
        this.answerfile = answerfile;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getCommitdate() {
        return commitdate;
    }

    public void setCommitdate(String commitdate) {
        this.commitdate = commitdate;
    }

    @Override
    public String toString() {
        return "Homework{" +
                ", studentid='" + studentid + '\'' +
                ", studentname='" + studentname + '\'' +
                ", chapterid='" + chapterid + '\'' +
                ", kechenid='" + kechenid + '\'' +
                ", answercontent='" + answercontent + '\'' +
                ", answerfile='" + answerfile + '\'' +
                ", score='" + score + '\'' +
                ", classid='" + classid + '\'' +
                ", commitdate='" + commitdate + '\'' +
                '}';
    }
}
