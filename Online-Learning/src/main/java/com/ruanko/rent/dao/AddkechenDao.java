package com.ruanko.rent.dao;


import com.ruanko.rent.entity.Addkechen;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddkechenDao {
    @Select("SELECT * FROM addkechen")
    @Results({
            @Result(property = "addkechenid",  column = "addkechenid"),
            @Result(property = "kechenid",  column = "kechenid"),
            @Result(property = "kechenname", column = "kechenname"),
            @Result(property = "kechenintro", column = "kechenintro"),
            @Result(property = "xuefen", column = "xuefen"),
            @Result(property = "teachername",  column = "teachername"),


    })
    List<Addkechen> getAll();

    @Select("SELECT * FROM addkechen WHERE addkechenid = #{addkechenid}")
    @Results({
            @Result(property = "addkechenid",  column = "addkechenid"),
            @Result(property = "kechenid",  column = "kechenid"),
            @Result(property = "kechenname", column = "kechenname"),
            @Result(property = "kechenintro", column = "kechenintro"),
            @Result(property = "xuefen", column = "xuefen"),
            @Result(property = "teachername",  column = "teachername"),


    })
    Addkechen getOne(String addkechenid);

    @Insert("INSERT INTO addkechen(addkechenid,kechenid, kechenname, kechenintro, xuefen,teachername) VALUES(#{addkechenid},#{kechenid}, #{kechenname}, #{kechenintro}, #{xuefen},#{teachername})")
    void insert(Addkechen addkechen);

    @Update("UPDATE addkechen SET addkechenid=#{addkechenid}, kechenid=#{kechenid}, kechenname = #{kechenname}, kechenintro = #{kechenintro},xuefen=#{xuefen}, teachername=#{teachername}")
    void update(Addkechen addkechen);

    @Delete("DELETE FROM addkechen WHERE addkechenid = #{addkechenid}")
    void delete(String addkechenid);
}
