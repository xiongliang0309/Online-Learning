package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component

public class Classes {

    private String classid;
    private String num;


    public Classes() {
        super();
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classid='" + classid + '\'' +
                "num='" + num + '\'' +
                '}';
    }
}
