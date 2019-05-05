package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Homework;
import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.service.AdminService;
import com.ruanko.rent.service.HomeworkService;
import com.ruanko.rent.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherAddScoreController {

    @Autowired
    private HomeworkService homeworkService;


    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(value="/teacherAddScore.action", method = POST)
    public String teacherAddScore(HttpSession session, String score, String chapterid,String kechenid,String studentid){
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
