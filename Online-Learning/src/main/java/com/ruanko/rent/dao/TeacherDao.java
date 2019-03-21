package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TeacherDao {

    @Select("SELECT * FROM teacher")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "registerdate", column = "registerdate")
    })
    List<Teacher> getAll();

    @Select("SELECT * FROM teacher WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "registerdate", column = "registerdate")
    })
    Teacher getOne(String id);

    @Insert("INSERT INTO teacher(id, password, name, phone, email, icon, registerdate) VALUES(#{id}, #{password}, #{name}, #{phone}, #{email}, #{icon}, #{registerdate})")
    void insert(Teacher teacher);

    @Update("UPDATE teacher SET id=#{id}, password = #{password}, name = #{name}, phone = #{phone}, email = #{email}, icon = #{icon}, registerdate = #{registerdate} WHERE id = #{id}")
    void update(Teacher teacher);

    @Delete("DELETE FROM teacher WHERE id = #{id}")
    void delete(String id);
}


