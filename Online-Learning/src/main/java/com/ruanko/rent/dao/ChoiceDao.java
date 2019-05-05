package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Choice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoiceDao {
    @Select("SELECT * FROM choice")
    @Results({
            @Result(property = "choiceid",  column = "choiceid"),
            @Result(property = "choicetitle", column = "choicetitle"),
            @Result(property = "choicea", column = "choicea"),
            @Result(property = "choiceb", column = "choiceb"),
            @Result(property = "choicec", column = "choicec"),
            @Result(property = "choiced", column = "choiced"),
            @Result(property = "kechenid", column = "kechenid"),
            @Result(property = "chapterid", column = "chapterid")

    })
    List<Choice> getAll();

    @Select("SELECT * FROM choice WHERE choiceid = #{choiceid}")
    @Results({
            @Result(property = "choiceid",  column = "choiceid"),
            @Result(property = "choicetitle", column = "choicetitle"),
            @Result(property = "choicea", column = "choicea"),
            @Result(property = "choiceb", column = "choiceb"),
            @Result(property = "choicec", column = "choicec"),
            @Result(property = "choiced", column = "choiced"),
            @Result(property = "kechenid", column = "kechenid"),
            @Result(property = "chapterid", column = "chapterid")
    })
    Choice getOne(String choiceid);

    @Insert("INSERT INTO choice(choiceid, choicetitle, choicea, choiceb, choicec, choiced, kechenid,chapterid) VALUES(#{choiceid}, #{choicetitle}, #{choicea}, #{choiceb}, #{choicec}, #{choiced},#{kechenid},#{chapterid})")
    void insert(Choice choice);

    @Update("UPDATE choice SET choiceid=#{choiceid}, choicetitle = #{choicetitle}, choicea = #{choicea}, choiceb = #{choiceb}, choicec = #{choicec}, choiced = #{choiced}, kechenid=#{kechenid}, chapterid=#{chapterid} WHERE choiceid = #{choiceid}")
    void update(Choice choice);

    @Delete("DELETE FROM choice WHERE choiceid = #{choiceid}")
    void delete(String choiceid);
}
