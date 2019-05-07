package com.ruanko.rent.dao;


import com.ruanko.rent.entity.Classes;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesDao {
    @Select("SELECT * FROM classes")
    @Results({
            @Result(property = "classid",  column = "classid"),
            @Result(property = "num", column = "num")
    })
    List<Classes> getAll();

    @Select("SELECT * FROM classes WHERE classid = #{classid}")
    @Results({
            @Result(property = "classid",  column = "classid"),
            @Result(property = "num", column = "num")

    })
    Classes getOne(String classid);

    @Insert("INSERT INTO classes(classid, num) VALUES(#{classid}, #{num})")
    void insert(Classes classes);

    @Update("UPDATE classes SET classid=#{classid}, num = #{num} WHERE classid = #{classid}")
    void update(Classes classes);

    @Delete("DELETE FROM classes WHERE classid = #{classid}")
    void delete(String classid);
}
