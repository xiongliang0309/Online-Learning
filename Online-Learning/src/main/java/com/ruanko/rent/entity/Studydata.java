package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Studydata {
    private String fileid;
    private String filename;
    private String filepath;
    private String filedate;
    private String filer;


    public Studydata() {
        super();
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFiledate() {
        return filedate;
    }

    public void setFiledate(String filedate) {
        this.filedate = filedate;
    }

    public String getFiler() {
        return filer;
    }

    public void setFiler(String filer) {
        this.filer = filer;
    }


    @Override
    public String toString() {
        return "Studydata{" +
                "fileid='" + fileid + '\'' +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                ", filedate='" + filedate + '\'' +
                ", fileer='" + filer + '\'' +
                '}';
    }
}
