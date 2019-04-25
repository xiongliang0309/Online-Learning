package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Studydata;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudydataDao {

    @Select("SELECT * FROM studydata")
    @Results({
            @Result(property = "fileid",  column = "fileid"),
            @Result(property = "filename", column = "filename"),
            @Result(property = "filepath", column = "filepath"),
            @Result(property = "filedate", column = "filedate"),
            @Result(property = "filer", column = "filer")
    })
    List<Studydata> getAll();

    @Select("SELECT * FROM studydata WHERE fileid = #{fileid}")
    @Results({
            @Result(property = "fileid",  column = "fileid"),
            @Result(property = "filename", column = "filename"),
            @Result(property = "filepath", column = "filepath"),
            @Result(property = "filedate", column = "filedate"),
            @Result(property = "filer", column = "filer")
    })
    Studydata getOne(String fileid);

    @Insert("INSERT INTO studydata(fileid, filename, filepath, filedate, filer) VALUES(#{fileid}, #{filename}, #{filepath}, #{filedate}, #{filer})")
    void insert(Studydata studydata);

    @Update("UPDATE student SET fileid=#{fileid}, filename = #{filename}, filepath = #{filepath}, filedate = #{filedate}, filer = #{filer} WHERE fileid = #{fileid}")
    void update(Studydata studydata);

    @Delete("DELETE FROM studydata WHERE fileid = #{fileid}")
    void delete(String fileid);
}
