package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Landlord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandlordDao {
    @Select("SELECT * FROM landlord")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "registerdate", column = "registerdate"),
            @Result(property = "teachername", column = "teachername"),
            @Result(property = "kechenid", column = "kechenid")

    })
    List<Landlord> getAll();

    @Select("SELECT * FROM landlord WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "registerdate", column = "registerdate"),
            @Result(property = "teachername", column = "teachername"),
            @Result(property = "kechenid", column = "kechenid")
    })
    Landlord getOne(String id);

    @Insert("INSERT INTO landlord(id, password, name, phone, email, icon, registerdate,teachername,kechenid) VALUES(#{id}, #{password}, #{name}, #{phone}, #{email}, #{icon}, #{registerdate},#{teachername},#{kechenid})")
    void insert(Landlord landlord);

    @Update("UPDATE landlord SET id=#{id},password = #{password}, name = #{name}, phone = #{phone}, email = #{email}, icon = #{icon}, registerdate = #{registerdate}, teachername=#{teachername},kechenid=#{kechenid}  WHERE id = #{id}")
    void update(Landlord landlord);

    @Delete("DELETE FROM landlord WHERE id = #{id}")
    void delete(String id);
}
