package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Course;
import com.ruanko.rent.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentCourseController {
    @Autowired
    private CourseService courseService;

    //跳转到课程页面
    @RequestMapping("/student_course")
    public String showTeacherCourse(Model model) {
        List<Course> courseList = courseService.getCourseList();
        model.addAttribute("courseList",courseList);
        return "student_course";
    }


}
