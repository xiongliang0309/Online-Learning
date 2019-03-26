package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private int id;
    private String name;
    private String teachername;
    private String coursedate;


    public Course() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", teachername='" + teachername + '\'' +
                ", coursedate='" + coursedate + '\'' +
                '}';
    }
}
