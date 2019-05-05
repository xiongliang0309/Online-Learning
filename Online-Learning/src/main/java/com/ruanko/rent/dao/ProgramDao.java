package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Program;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramDao {
    @Select("SELECT * FROM program")
    @Results({
            @Result(property = "programid",  column = "programid"),
            @Result(property = "programcontent", column = "programcontent"),
            @Result(property = "chapterid", column = "chapterid"),
            @Result(property = "kechenid", column = "kechenid")

    })
    List<Program> getAll();

    @Select("SELECT * FROM program WHERE programid = #{programid}")
    @Results({
            @Result(property = "programid",  column = "programid"),
            @Result(property = "programcontent", column = "programcontent"),
            @Result(property = "chapterid", column = "chapterid"),
            @Result(property = "kechenid", column = "kechenid")
    })
    Program getOne(String programid);

    @Insert("INSERT INTO program(programid, programcontent, chapterid, kechenid) VALUES(#{programid}, #{programcontent}, #{chapterid}, #{kechenid})")
    void insert(Program program);

    @Update("UPDATE program SET programid=#{programid}, programcontent = #{programcontent}, chapterid = #{chapterid}, kechenid = #{kechenid} WHERE programid = #{programid}")
    void update(Program program);

    @Delete("DELETE FROM program WHERE programid = #{programid}")
    void delete(String programid);
}
