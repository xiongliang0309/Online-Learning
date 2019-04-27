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
            @Result(property = "kechenid", column = "kechenid")
    })
    List<Chapter> getAll();

    @Select("SELECT * FROM chapter WHERE chapterid = #{chapterid}")
    @Results({
            @Result(property = "chapterid",  column = "chapterid"),
            @Result(property = "chaptername", column = "chaptername"),
            @Result(property = "kechenid", column = "kechenid")

    })
    Chapter getOne(String chapterid);

    @Insert("INSERT INTO chapter(chapterid, chaptername, kechenid) VALUES(#{chapterid}, #{chaptername}, #{kechenid})")
    void insert(Chapter chapter);

    @Update("UPDATE chapter SET chapterid=#{chapterid}, chaptername = #{chaptername}, kechenid = #{kechendi}")
    void update(Chapter chapter);

    @Delete("DELETE FROM chapter WHERE chapterid = #{chapterid} and kechenid=#{kechenid}")
    void delete(String chapterid,String kechenid);
}
