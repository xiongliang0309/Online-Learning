package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Kechen {
    private String kechenid;
    private String kechenname;
    private String kechenintro;
    private String xuefen;



    public Kechen() {
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

    @Override
    public String toString() {
        return "Kechen{" +
                "kechenid='" + kechenid + '\'' +
                ", kechenname='" + kechenname + '\'' +
                ", kechenintro='" + kechenintro + '\'' +
                ", xuefen='" + xuefen + '\'' +
                '}';
    }
}
