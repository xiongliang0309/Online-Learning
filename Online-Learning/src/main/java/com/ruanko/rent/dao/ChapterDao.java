package com.ruanko.rent.dao;


import com.ruanko.rent.entity.Chapter;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterDao {
    @Select("SELECT * FROM chapter")
    @Results({
            @Result(property = "chapterid",  column = "chapterid"),
            @Result(property = "chaptername", column = "chaptername"),
            @Result(property = "kechenid", column = "kechenid"),
            @Result(property = "isupload", column = "isupload"),
            @Result(property = "teachername", column = "teachername")
    })
    List<Chapter> getAll();

    @Select("SELECT * FROM chapter WHERE chapterid = #{chapterid}")
    @Results({
            @Result(property = "chapterid",  column = "chapterid"),
            @Result(property = "chaptername", column = "chaptername"),
            @Result(property = "kechenid", column = "kechenid"),
            @Result(property = "isupload", column = "isupload"),
            @Result(property = "teachername", column = "teachername")


    })
    Chapter getOne(String chapterid);

    @Insert("INSERT INTO chapter(chapterid, chaptername, kechenid,isupload,teachername) VALUES(#{chapterid}, #{chaptername}, #{kechenid}, #{isupload}, #{teachername})")
    void insert(Chapter chapter);

    @Update("UPDATE chapter SET chapterid=#{chapterid}, chaptername = #{chaptername}, kechenid = #{kechenid}, isupload = #{isupload}, teachername = #{teachername} WHERE chapterid = #{chapterid}")
    void update(Chapter chapter);

    @Delete("DELETE FROM chapter WHERE chapterid = #{chapterid}")
    void delete(String chapterid);
}
