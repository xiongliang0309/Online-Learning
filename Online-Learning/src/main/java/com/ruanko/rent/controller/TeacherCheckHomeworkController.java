package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Addkechen;
import com.ruanko.rent.entity.Homework;
import com.ruanko.rent.service.AddkechenService;
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

    @Autowired
    private AddkechenService addkechenService;

    //老师批改学生作业列表
    @RequestMapping("/teacher_check_homework")
    public String teacherCheckHomework(Model model) {
        List<Addkechen> addkechenList = addkechenService.getAddkechenList();
        model.addAttribute("addkechenList", addkechenList);
//        List<Homework> homeworkList = homeworkService.getHomeworkList();
//        model.addAttribute("homeworkList", homeworkList);
        return "teacher_check_homework";
    }

    @RequestMapping("/teacherKechenHomeworkList")
    public String teacherKechenHomeworkList(Model model,String addkechenid) {
       Addkechen addkechen=addkechenService.findAddkechenById(addkechenid);
       model.addAttribute("addkechen",addkechen);
        List<Homework> homeworkList = homeworkService.getHomeworkList();
        model.addAttribute("homeworkList", homeworkList);
        return "teacher_homework_list";
    }

   //批改作业
   @RequestMapping("/teacherCheckHomework")
   public String teacherDiscussDetail(Model model, String chapterid,String kechenid,String studentid,String addkechenid) {
       Homework homework = homeworkService.findHomeworkById(chapterid,kechenid,studentid);
       model.addAttribute("homework", homework);
       System.out.println(addkechenid);
       model.addAttribute("addkechenid", addkechenid);
       return "teacher_check_homework_detail";
   }
}
