package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Addkechen {
    private String addkechenid;
    private String kechenid;
    private String kechenname;
    private String kechenintro;
    private String xuefen;
    private String teachername;



    public Addkechen() {
        super();
    }

    public String getKechenid() {
        return kechenid;
    }

    public void setKechenid(String kechenid) {
        this.kechenid = kechenid;
    }

    public String getKechenname() {
        return kechenname;
    }

    public void setKechenname(String kechenname) {
        this.kechenname = kechenname;
    }

    public String getKechenintro() {
        return kechenintro;
    }

    public void setKechenintro(String kechenintro) {
        this.kechenintro = kechenintro;
    }

    public String getXuefen() {
        return xuefen;
    }

    public void setXuefen(String xuefen) {
        this.xuefen = xuefen;
    }

    public String getAddkechenid() {
        return addkechenid;
    }

    public void setAddkechenid(String addkechenid) {
        this.addkechenid = addkechenid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    @Override
    public String toString() {
        return "Addkechen{" +
                "addkechenid='" + addkechenid + '\'' +
                "kechenid='" + kechenid + '\'' +
                ", kechenname='" + kechenname + '\'' +
                ", kechenintro='" + kechenintro + '\'' +
                ", xuefen='" + xuefen + '\'' +
                ", teachername='" + teachername + '\'' +
                '}';
    }
}
