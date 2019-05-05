package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Homework;
import com.ruanko.rent.entity.House;
import com.ruanko.rent.entity.Landlord;
import com.ruanko.rent.service.HomeworkService;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.service.LandlordService;
import com.ruanko.rent.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HelpCheckHomeworkController {
    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private House house;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/help_check_homework")
    public String teacherCheckHomework(Model model) {
        List<Homework> homeworkList = homeworkService.getHomeworkList();
        model.addAttribute("homeworkList", homeworkList);
        return "help_check_homework";
    }

    //批改作业
    @RequestMapping("/helpCheckHomework")
    public String teacherDiscussDetail(Model model, String homeworkid) {
        Homework homework = homeworkService.findHomeworkById(homeworkid);
        model.addAttribute("homework", homework);
        return "help_check_homework_detail";
    }

//评分
    @RequestMapping(value="/helpAddScore.action", method = POST)
    public String teacherAddScore(HttpSession session, String score, String homeworkid){
        Homework homework = homeworkService.findHomeworkById(homeworkid);
        homework.setScore(score);

        //保存到数据库
        try{
            homeworkService.edit(homework);
            return "redirect:/help_check_homework";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
