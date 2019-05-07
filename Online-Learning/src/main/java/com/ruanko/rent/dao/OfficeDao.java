package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Office;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeDao {
    @Select("SELECT * FROM office")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "registerdate", column = "registerdate")
    })
    List<Office> getAll();

    @Select("SELECT * FROM office WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "registerdate", column = "registerdate")
    })
    Office getOne(String id);

    @Insert("INSERT INTO office(id, password, name, phone, email, icon, registerdate) VALUES(#{id}, #{password}, #{name}, #{phone}, #{email}, #{icon}, #{registerdate})")
    void insert(Office office);

    @Update("UPDATE office SET id=#{id}, password = #{password}, name = #{name}, phone = #{phone}, email = #{email}, icon = #{icon}, registerdate = #{registerdate} WHERE id = #{id}")
    void update(Office office);

    @Delete("DELETE FROM office WHERE id = #{id}")
    void delete(String id);
}
