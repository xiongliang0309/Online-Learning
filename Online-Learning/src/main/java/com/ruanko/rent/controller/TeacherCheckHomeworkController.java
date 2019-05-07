package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Homework;
import com.ruanko.rent.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class TeacherCheckHomeworkController {
    @Autowired
    private HomeworkService homeworkService;

    //老师批改学生作业列表
    @RequestMapping("/teacher_check_homework")
    public String teacherCheckHomework(Model model) {
        List<Homework> homeworkList = homeworkService.getHomeworkList();
        model.addAttribute("homeworkList", homeworkList);
        return "teacher_check_homework";
    }

   //批改作业
   @RequestMapping("/teacherCheckHomework")
   public String teacherDiscussDetail(Model model, String chapterid,String kechenid,String studentid) {
       Homework homework = homeworkService.findHomeworkById(chapterid,kechenid,studentid);
       model.addAttribute("homework", homework);
       return "teacher_check_homework_detail";
   }
}
