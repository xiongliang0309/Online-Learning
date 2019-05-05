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
            @Result(property = "isupload", column = "isupload")
    })
    List<Chapter> getAll();

    @Select("SELECT * FROM chapter WHERE chapterid = #{chapterid} and kechenid= #{kechenid}")
    @Results({
            @Result(property = "chapterid",  column = "chapterid"),
            @Result(property = "chaptername", column = "chaptername"),
            @Result(property = "kechenid", column = "kechenid"),
            @Result(property = "isupload", column = "isupload")

    })
    Chapter getOne(String chapterid,String kechenid);

    @Insert("INSERT INTO chapter(chapterid, chaptername, kechenid,isupload) VALUES(#{chapterid}, #{chaptername}, #{kechenid}, #{isupload})")
    void insert(Chapter chapter);

    @Update("UPDATE chapter SET chapterid=#{chapterid}, chaptername = #{chaptername}, kechenid = #{kechenid}, isupload = #{isupload} WHERE chapterid = #{chapterid} and kechenid=#{kechenid}")
    void update(Chapter chapter);

    @Delete("DELETE FROM chapter WHERE chapterid = #{chapterid} and kechenid=#{kechenid}")
    void delete(String chapterid,String kechenid);
}
