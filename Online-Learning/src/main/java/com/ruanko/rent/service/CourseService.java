package com.ruanko.rent.service;

import com.ruanko.rent.dao.CourseDao;
import com.ruanko.rent.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    public List<Course> getCourseList(){
        return courseDao.getAll();
    }

    public Course findCourseById(String id){
        return  courseDao.getOne(id);
    }

    public void save(Course course) {
        courseDao.insert(course);
    }

    public void edit(Course course){
        courseDao.update(course);
    }

    public void delete(String id) {
        courseDao.delete(id);
    }
}
