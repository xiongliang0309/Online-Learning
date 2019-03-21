package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Score {
    private String stuid;
    private String courseid;
    private String coursename;
    private String stuname;
    private String score;

    public Score() {
        super();
    }

    public String getStuid() {
        return stuid;
    }

    public void setId(String stuid) {
        this.stuid = stuid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Score{" +
                "stuid='" + stuid + '\'' +
                ", courseid='" + courseid + '\'' +
                ", coursename='" + coursename + '\'' +
                ", stuname='" + stuname + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
