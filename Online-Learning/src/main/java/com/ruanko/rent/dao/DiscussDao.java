package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Discuss;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussDao {
    @Select("SELECT * FROM discuss")
    @Results({
            @Result(property = "discussid",  column = "discussid"),
            @Result(property = "discusstitle", column = "discusstitle"),
            @Result(property = "discusscontent", column = "discusscontent"),
            @Result(property = "discussdate", column = "discussdate"),
            @Result(property = "discusser", column = "discusser")
    })
    List<Discuss> getAll();

    @Select("SELECT * FROM discuss WHERE discussid = #{discussid}")
    @Results({
            @Result(property = "discussid",  column = "discussid"),
            @Result(property = "discusstitle", column = "discusstitle"),
            @Result(property = "discusscontent", column = "discusscontent"),
            @Result(property = "discussdate", column = "discussdate"),
            @Result(property = "discusser", column = "discusser")
    })
    Discuss getOne(String discussid);

    @Insert("INSERT INTO discuss(discussid, discusstitle, discusscontent, discussdate, discusser) VALUES(#{discussid}, #{discusstitle}, #{discusscontent}, #{discussdate}, #{discusser})")
    void insert(Discuss discuss);

    @Update("UPDATE discuss SET discussid=#{discussid}, discusstitle = #{discusstitle}, discusscontent = #{discusscontent}, discussdate = #{discussdate}, discusser = #{discusser} WHERE discussid = #{discussid}")
    void update(Discuss discuss);

    @Delete("DELETE FROM discuss WHERE discussid = #{discussid}")
    void delete(String discussid);
}
