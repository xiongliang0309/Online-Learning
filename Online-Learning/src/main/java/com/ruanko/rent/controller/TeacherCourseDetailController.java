package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Course;
import com.ruanko.rent.entity.Leaseholder;
import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.service.CourseService;
import com.ruanko.rent.service.LeaseholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class TeacherCourseDetailController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private LeaseholderService leaseholderService;

    //跳转到Course详情界面
    @RequestMapping("/teacherCourseDetail")
    public String teacherShowCourseDetailInfo(Model model, String id) {
        Course course = courseService.findCourseById(id);
        model.addAttribute("course", course);
        return "teacher_course_detail_info";
    }

    @RequestMapping("/teacherCourseStudent")
    public String teacherCourseStudent(Model model, String id) {
        Course course = courseService.findCourseById(id);
        model.addAttribute("course", course);

        List<Leaseholder> leaseholderList = leaseholderService.getLeaseholderList();
        model.addAttribute("leaseholderList", leaseholderList);

        return "teacher_studentofcourselist";
    }
}
