package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    @Select("SELECT * FROM comment")
    @Results({
            @Result(property = "commentid",  column = "commentid"),
            @Result(property = "commenter", column = "commenter"),
            @Result(property = "commentcontent", column = "commentcontent"),
            @Result(property = "commentdate", column = "commentdate"),
            @Result(property = "discussid", column = "discussid")
    })
    List<Comment> getAll();

    @Select("SELECT * FROM comment WHERE commentid = #{commentid}")
    @Results({
            @Result(property = "commentid",  column = "commentid"),
            @Result(property = "commenter", column = "commenter"),
            @Result(property = "commentcontent", column = "commentcontent"),
            @Result(property = "commentdate", column = "commentdate"),
            @Result(property = "discussid", column = "discussid")
    })
    Comment getOne(String commentid);

    @Insert("INSERT INTO comment(commentid, commenter, commentcontent, commentdate, discussid) VALUES(#{commentid}, #{commenter}, #{commentcontent}, #{commentdate}, #{discussid})")
    void insert(Comment comment);

    @Update("UPDATE comment SET commentid=#{commentid}, commenter = #{commenter}, commentcontent = #{commentcontent}, commentdate = #{commentdate}, discussid = #{discussid} WHERE commentid = #{commentid}")
    void update(Comment comment);

    @Delete("DELETE FROM comment WHERE commentid = #{commentid}")
    void delete(String commentid);
}
