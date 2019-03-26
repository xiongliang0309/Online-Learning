package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Course;
import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.service.AdminService;
import com.ruanko.rent.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherAddCourseController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private Course course;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/teacher_addcourse")
    public String showTeacherAddCourse() {
        return "teacher_addcourse";
    }

    @RequestMapping(value="/addCourse.action", method = POST)
    public String teacherAddNotice(HttpSession session, String name){
        Admin admin = (Admin) session.getAttribute("admin");
        course.setName(name);
        course.setTeachername(admin.getName());
        course.setCoursedate(sdf.format(date));


        //保存到数据库
        try{
            courseService.save(course);
            return "redirect:/teacher_course";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
