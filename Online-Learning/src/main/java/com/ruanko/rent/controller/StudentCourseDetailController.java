package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Course;
import com.ruanko.rent.entity.Chapter;
import com.ruanko.rent.service.CourseService;
import com.ruanko.rent.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@Controller
public class StudentCourseDetailController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private ChapterService chapterService;


    //显示课程作业章节
    @RequestMapping("/studentCourseDetail")
    public String teacherCourseChapter(Model model, String id) {
        Course course = courseService.findCourseById(id);
        model.addAttribute("course", course);
        List<Chapter> chapterList = chapterService.getChapterList();
        model.addAttribute("chapterList", chapterList);
        return "student_course_detail";
    }


}
