package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Course;
import com.ruanko.rent.entity.Admin;
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
    private CourseService courseService;
    @Autowired
    private Course course;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/teacher_addcourse")
    public String showTeacherAddCourse() {
        return "teacher_addcourse";
    }

    //教师添加我的课程
    @RequestMapping(value="/addCourse.action", method = POST)
    public String teacherAddCourse(HttpSession session,String classid,String intro){
        Admin admin = (Admin) session.getAttribute("admin");
        course.setTeachername(admin.getName());
        course.setClassid(classid);
        course.setIntro(intro);
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
