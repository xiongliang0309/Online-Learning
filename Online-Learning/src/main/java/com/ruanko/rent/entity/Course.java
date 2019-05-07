package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private String id;
    private String kechenname;
    private String teachername;
    private String coursedate;
    private String classid;
    private  String intro;
    private  String kechenid;



    public Course() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getCoursedate() {
        return coursedate;
    }

    public void setCoursedate(String coursedate) {
        this.coursedate = coursedate;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) { this.intro = intro; }

    public String getKechenname() {
        return kechenname;
    }

    public void setKechenname(String kechenname) {
        this.kechenname = kechenname;
    }

    public String getKechenid() {
        return kechenid;
    }

    public void setKechenid(String kechenid) {
        this.kechenid = kechenid;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", kechenname='" + kechenname + '\'' +
                ", teachername='" + teachername + '\'' +
                ", coursedate='" + coursedate + '\'' +
                ", classid='" + classid + '\'' +
                ", intro='" + intro + '\'' +
                ", kechenid='" + kechenid + '\'' +
                '}';
    }
}
