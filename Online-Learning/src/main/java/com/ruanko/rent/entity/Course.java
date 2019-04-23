package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private String id;
    private String name;
    private String teachername;
    private String coursedate;
    private String classid;
    private  String intro;


    public Course() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", teachername='" + teachername + '\'' +
                ", coursedate='" + coursedate + '\'' +
                ", classid='" + classid + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
