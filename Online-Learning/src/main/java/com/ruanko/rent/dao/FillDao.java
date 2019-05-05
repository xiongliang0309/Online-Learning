package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Fill;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FillDao {
    @Select("SELECT * FROM fill")
    @Results({
            @Result(property = "fillid",  column = "fillid"),
            @Result(property = "fillcontent", column = "fillcontent"),
            @Result(property = "chapterid", column = "chapterid"),
            @Result(property = "kechenid", column = "kechenid")

    })
    List<Fill> getAll();

    @Select("SELECT * FROM fill WHERE fillid = #{fillid}")
    @Results({
            @Result(property = "fillid",  column = "fillid"),
            @Result(property = "fillcontent", column = "fillcontent"),
            @Result(property = "chapterid", column = "chapterid"),
            @Result(property = "kechenid", column = "kechenid")
    })
    Fill getOne(String fillid);

    @Insert("INSERT INTO fill(fillid, fillcontent, chapterid, kechenid) VALUES(#{fillid}, #{fillcontent}, #{chapterid}, #{kechenid})")
    void insert(Fill fill);

    @Update("UPDATE fill SET fillid=#{fillid}, fillcontent = #{fillcontent}, chapterid = #{chapterid}, kechenid = #{kechenid} WHERE fillid = #{fillid}")
    void update(Fill fill);

    @Delete("DELETE FROM fill WHERE fillid = #{fillid}")
    void delete(String fillid);
}
