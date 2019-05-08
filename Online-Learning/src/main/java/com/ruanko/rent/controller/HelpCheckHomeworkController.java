package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Addkechen;
import com.ruanko.rent.entity.Homework;
import com.ruanko.rent.service.AddkechenService;
import com.ruanko.rent.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HelpCheckHomeworkController {

    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private AddkechenService addkechenService;


    //显示作业
    @RequestMapping("/help_check_homework")
    public String teacherCheckHomework(Model model) {
        List<Addkechen> addkechenList = addkechenService.getAddkechenList();
        model.addAttribute("addkechenList", addkechenList);
//        List<Homework> homeworkList = homeworkService.getHomeworkList();
//        model.addAttribute("homeworkList", homeworkList);
        return "help_check_homework";
    }

    @RequestMapping("/helpKechenHomeworkList")
    public String teacherKechenHomeworkList(Model model,String addkechenid) {
        Addkechen addkechen=addkechenService.findAddkechenById(addkechenid);
        model.addAttribute("addkechen",addkechen);
        List<Homework> homeworkList = homeworkService.getHomeworkList();
        model.addAttribute("homeworkList", homeworkList);
        return "help_homework_list";
    }

    //批改作业
    @RequestMapping("/helpCheckHomework")
    public String teacherDiscussDetail(Model model, String chapterid,String kechenid,String studentid,String addkechenid) {
        Homework homework = homeworkService.findHomeworkById(chapterid,kechenid,studentid);
        model.addAttribute("homework", homework);
        System.out.println(addkechenid);
        model.addAttribute("addkechenid", addkechenid);
        return "help_check_homework_detail";
    }

    //评分
    @RequestMapping(value="/helpAddScore.action", method = POST)
    public String helpAddScore(String score, String chapterid,String kechenid,String studentid,String addkechenid){
        Homework homework = homeworkService.findHomeworkById(chapterid,kechenid,studentid);
        homework.setScore(score);

        //保存到数据库
        try{
            homeworkService.edit(homework);
            return "redirect:/helpKechenHomeworkList?addkechenid="+addkechenid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
