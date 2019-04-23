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
            @Result(property = "name", column = "name"),
            @Result(property = "teachername", column = "teachername"),
            @Result(property = "coursedate", column = "coursedate"),
            @Result(property = "classid", column = "classid"),
            @Result(property = "intro", column = "intro")

    })
    List<Course> getAll();

    @Select("SELECT * FROM course WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "teachername", column = "teachername"),
            @Result(property = "coursedate", column = "coursedate"),
            @Result(property = "classid", column = "classid"),
            @Result(property = "intro", column = "intro")

    })
    Course getOne(String id);

    @Insert("INSERT INTO course(id, name, teachername, coursedate, classid, intro) VALUES(#{id}, #{name}, #{teachername}, #{coursedate}, #{classid}, #{intro})")
    void insert(Course course);

    @Update("UPDATE course SET id=#{id}, name = #{name}, teachername = #{teachername},coursedate=#{coursedate},classid=#{classid},intro=#{intro}")
    void update(Course course);

    @Delete("DELETE FROM course WHERE id = #{id}")
    void delete(String id);
}
