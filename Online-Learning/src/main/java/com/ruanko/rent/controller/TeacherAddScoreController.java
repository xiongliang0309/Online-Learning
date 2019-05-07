package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Homework;
import com.ruanko.rent.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherAddScoreController {

    @Autowired
    private HomeworkService homeworkService;


//教师批改作业评分
    @RequestMapping(value="/teacherAddScore.action", method = POST)
    public String teacherAddScore(String score, String chapterid,String kechenid,String studentid){
        Homework homework = homeworkService.findHomeworkById(chapterid,kechenid,studentid);
        homework.setScore(score);

        //保存到数据库
        try{
            homeworkService.edit(homework);
            return "redirect:/teacher_check_homework";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
