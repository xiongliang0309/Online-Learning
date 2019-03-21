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
    })
    List<Course> getAll();

    @Select("SELECT * FROM course WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "teachername", column = "teachername"),
    })
    Course getOne(int id);

    @Insert("INSERT INTO course(id, name, teachername) VALUES(#{id}, #{name}, #{teachername})")
    void insert(Course course);

    @Update("UPDATE course SET id=#{id}, name = #{name}, teachername = #{teachername}")
    void update(Course course);

    @Delete("DELETE FROM course WHERE id = #{id}")
    void delete(int id);
}
