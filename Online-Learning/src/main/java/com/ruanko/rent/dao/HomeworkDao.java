package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Homework;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkDao {
    @Select("SELECT * FROM homework")
    @Results({
            @Result(property = "studentid", column = "studentid"),
            @Result(property = "studentname", column = "studentname"),
            @Result(property = "chapterid", column = "chapterid"),
            @Result(property = "kechenid", column = "kechenid"),
            @Result(property = "answercontent", column = "answercontent"),
            @Result(property = "answerfile", column = "answerfile"),
            @Result(property = "score", column = "score"),
            @Result(property = "classid", column = "classid"),
            @Result(property = "commitdate", column = "commitdate"),
            @Result(property = "teachername", column = "teachername")

    })
    List<Homework> getAll();

    @Select("SELECT * FROM homework WHERE chapterid = #{chapterid} and kechenid=#{kechenid} and studentid=#{studentid}")
    @Results({
            @Result(property = "studentid", column = "studentid"),
            @Result(property = "studentname", column = "studentname"),
            @Result(property = "chapterid", column = "chapterid"),
            @Result(property = "kechenid", column = "kechenid"),
            @Result(property = "answercontent", column = "answercontent"),
            @Result(property = "answerfile", column = "answerfile"),
            @Result(property = "score", column = "score"),
            @Result(property = "classid", column = "classid"),
            @Result(property = "commitdate", column = "commitdate"),
            @Result(property = "teachername", column = "teachername")

    })
   Homework getOne(String chapterid,String kechenid,String studentid);

    @Select("SELECT * FROM homework WHERE classid=#{classid} and kechenid=#{kechenid}")
    @Results({
            @Result(property = "studentid", column = "studentid"),
            @Result(property = "studentname", column = "studentname"),
            @Result(property = "chapterid", column = "chapterid"),
            @Result(property = "kechenid", column = "kechenid"),
            @Result(property = "answercontent", column = "answercontent"),
            @Result(property = "answerfile", column = "answerfile"),
            @Result(property = "score", column = "score"),
            @Result(property = "classid", column = "classid"),
            @Result(property = "commitdate", column = "commitdate"),
            @Result(property = "teachername", column = "teachername")
    })
    List <Homework> getScore(String classid,String kechenid);



    @Insert("INSERT INTO homework(studentid, studentname, chapterid, kechenid, answercontent, answerfile,score,classid,commitdate,teachername) VALUES(#{studentid}, #{studentname}, #{chapterid}, #{kechenid}, #{answercontent},#{answerfile},#{score},#{classid},#{commitdate} ,#{teachername}) ON DUPLICATE KEY UPDATE  answercontent = #{answercontent}, answerfile=#{answerfile}, score=#{score}, commitdate=#{commitdate}, teachername=#{teachername}")
    void insert(Homework homework);

    @Update("UPDATE homework SET  studentid = #{studentid}, studentname = #{studentname}, chapterid = #{chapterid}, kechenid = #{kechenid}, answercontent = #{answercontent}, answerfile=#{answerfile}, score=#{score}, classid=#{classid}, commitdate=#{commitdate} WHERE chapterid = #{chapterid} and kechenid=#{kechenid} and studentid=#{studentid}")
    void update(Homework homework);

    @Delete("DELETE FROM homework WHERE chapterid = #{chapterid} and kechenid = #{kechenid} and studentid = #{studentid}")
    void delete(String chapterid,String kechenid,String studentid);
}
