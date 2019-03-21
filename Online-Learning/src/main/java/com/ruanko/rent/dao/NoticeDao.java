package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao {
    @Select("SELECT * FROM notice")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "title",  column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "noticer", column = "noticer"),
            @Result(property = "noticedate", column = "noticedate")
    })
    List<Notice> getAll();

    @Select("SELECT * FROM notice WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "title",  column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "noticer", column = "noticer"),
            @Result(property = "noticedate", column = "noticedate")
    })
    Notice getOne(String id);

    @Insert("INSERT INTO notice(id,title, content, noticer, noticedate) VALUES(#{id}, #{title}, #{content}, #{noticer}, #{noticedate})")
    void insert(Notice notice);

    @Update("UPDATE notice SET id=#{id}, title = #{title}, content = #{content}, noticer = #{noticer}, noticedate = #{noticedate} WHERE id = #{id}")
    void update(Notice notice);

    @Delete("DELETE FROM notice WHERE id = #{id}")
    void delete(String id);
}
