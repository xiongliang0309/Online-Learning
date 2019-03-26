package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Admin;
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
    })
    List<Course> getAll();

    @Select("SELECT * FROM course WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "teachername", column = "teachername"),
            @Result(property = "coursedate", column = "coursedate")
    })
    Course getOne(int id);

    @Insert("INSERT INTO course(id, name, teachername,coursedate) VALUES(#{id}, #{name}, #{teachername},#{coursedate})")
    void insert(Course course);

    @Update("UPDATE course SET id=#{id}, name = #{name}, teachername = #{teachername},coursedate=#{coursedate}")
    void update(Course course);

    @Delete("DELETE FROM course WHERE id = #{id}")
    void delete(int id);
}
