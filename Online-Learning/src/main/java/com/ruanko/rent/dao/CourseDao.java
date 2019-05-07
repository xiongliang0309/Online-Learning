package com.ruanko.rent.dao;


import com.ruanko.rent.entity.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    @Select("SELECT * FROM course")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "kechenname", column = "kechenname"),
            @Result(property = "teachername", column = "teachername"),
            @Result(property = "coursedate", column = "coursedate"),
            @Result(property = "classid", column = "classid"),
            @Result(property = "intro", column = "intro"),
            @Result(property = "kechenid", column = "kechenid")

    })
    List<Course> getAll();

    @Select("SELECT * FROM course WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "kechenname", column = "kechenname"),
            @Result(property = "teachername", column = "teachername"),
            @Result(property = "coursedate", column = "coursedate"),
            @Result(property = "classid", column = "classid"),
            @Result(property = "intro", column = "intro"),
            @Result(property = "kechenid", column = "kechenid")

    })
    Course getOne(String id);

    @Insert("INSERT INTO course(id, kechenname, teachername, coursedate, classid, intro,kechenid) VALUES(#{id}, #{kechenname}, #{teachername}, #{coursedate}, #{classid}, #{intro}, #{kechenid})")
    void insert(Course course);

    @Update("UPDATE course SET id=#{id}, kechenname = #{kechenname}, teachername = #{teachername},coursedate=#{coursedate},classid=#{classid},intro=#{intro},kechenid=#{kechenid}")
    void update(Course course);

    @Delete("DELETE FROM course WHERE id = #{id}")
    void delete(String id);
}
