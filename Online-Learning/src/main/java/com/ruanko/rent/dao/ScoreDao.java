package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Score;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreDao {
    @Select("SELECT * FROM score")
    @Results({
            @Result(property = "stuid",  column = "stuid"),
            @Result(property = "courseid", column = "courseid"),
            @Result(property = "coursename", column = "coursename"),
            @Result(property = "stuname", column = "stuname"),
            @Result(property = "score", column = "score"),
    })
    List<Score> getAll();

    @Select("SELECT * FROM score WHERE id = #{id}")
    @Results({
            @Result(property = "stuid",  column = "stuid"),
            @Result(property = "courseid", column = "courseid"),
            @Result(property = "coursename", column = "coursename"),
            @Result(property = "stuname", column = "stuname"),
            @Result(property = "score", column = "score"),
    })
    Score getOne(String id);

    @Insert("INSERT INTO score(stuid, courseid, coursename, stuname, score) VALUES(#{stuid}, #{courseid}, #{coursename}, #{stuname}, #{score})")
    void insert(Score score);

    @Update("UPDATE score SET stuid=#{stuid}, courseid = #{courseid}, coursename = #{coursename}, stuname = #{stuname}, score = #{score}")
    void update(Score score);

    @Delete("DELETE FROM score WHERE stuid = #{stuid}")
    void delete(String id);
}
