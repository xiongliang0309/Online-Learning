package com.ruanko.rent.dao;


import com.ruanko.rent.entity.Kechen;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KechenDao {
    @Select("SELECT * FROM kechen")
    @Results({
            @Result(property = "kechenid",  column = "kechenid"),
            @Result(property = "kechenname", column = "kechenname"),
            @Result(property = "kechenintro", column = "kechenintro"),
            @Result(property = "xuefen", column = "xuefen")

    })
    List<Kechen> getAll();

    @Select("SELECT * FROM kechen WHERE kechenid = #{kechenid}")
    @Results({
            @Result(property = "kechenid",  column = "kechenid"),
            @Result(property = "kechenname", column = "kechenname"),
            @Result(property = "kechenintro", column = "kechenintro"),
            @Result(property = "xuefen", column = "xuefen")

    })
    Kechen getOne(String kechenid);

    @Insert("INSERT INTO kechen(kechenid, kechenname, kechenintro, xuefen) VALUES (#{kechenid}, #{kechenname}, #{kechenintro}, #{xuefen}) ON DUPLICATE KEY UPDATE  kechenname=#{kechenname},kechenintro=#{kechenintro},xuefen=#{xuefen}")
    void insert(Kechen kechen);

    @Update("UPDATE kechen SET kechenid=#{kechenid}, kechenname = #{kechenname}, kechenintro = #{kechenintro},xuefen=#{xuefen}")
    void update(Kechen kechen);

    @Delete("DELETE FROM kechen WHERE kechenid = #{kechenid}")
    void delete(String kechenid);
}
