package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Homework;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkDao {
    @Select("SELECT * FROM homework")
    @Results({
            @Result(property = "homeworkid",  column = "homeworkid"),
            @Result(property = "studentid", column = "studentid"),
            @Result(property = "studentname", column = "studentname"),
            @Result(property = "chapterid", column = "chapterid"),
            @Result(property = "kechenid", column = "kechenid"),
            @Result(property = "answercontent", column = "answercontent"),
            @Result(property = "answerfile", column = "answerfile"),
            @Result(property = "score", column = "score"),
            @Result(property = "classid", column = "classid")

    })
    List<Homework> getAll();

    @Select("SELECT * FROM homework WHERE homeworkid = #{homework}")
    @Results({
            @Result(property = "homeworkid",  column = "homeworkid"),
            @Result(property = "studentid", column = "studentid"),
            @Result(property = "studentname", column = "studentname"),
            @Result(property = "chapterid", column = "chapterid"),
            @Result(property = "kechenid", column = "kechenid"),
            @Result(property = "answercontent", column = "answercontent"),
            @Result(property = "answerfile", column = "answerfile"),
            @Result(property = "score", column = "score"),
            @Result(property = "classid", column = "classid")
    })
    Homework getOne(String homeworkid);

    @Insert("INSERT INTO homework(homeworkid, studentid, studentname, chapterid, kechenid, answercontent, answerfile,score,classid) VALUES(#{homeworkid}, #{studentid}, #{studentname}, #{chapterid}, #{kechenid}, #{answercontent},#{answerfile},#{score},#{classid})")
    void insert(Homework homework);

    @Update("UPDATE homework SET homeworkid=#{homeworkid}, studentid = #{studentid}, studentname = #{studentname}, chapterid = #{chapterid}, kechenid = #{kechenid}, answercontent = #{answercontent}, answerfile=#{answerfile}, score=#{score}, classid=#{classid} WHERE homeworkid = #{homeworkid}")
    void update(Homework homework);

    @Delete("DELETE FROM homework WHERE homeworkid = #{homeworkid}")
    void delete(String homeworkid);
}
