package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Homework;
import com.ruanko.rent.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherSimilarController {
    @Autowired
    private HomeworkService homeworkService;

    //显示作业
    @RequestMapping("/teacher_similar")
    public String showStudentNoticeList(Model model) {
        List<Homework> homeworkList = homeworkService.getHomeworkList();
        model.addAttribute("homeworkList", homeworkList);
        return "teacher_similar";
    }


    //查重
    @RequestMapping(value="/teacherCheckSimilar.action", method = POST)

    public String teacherCheckSimilar(Model model,HttpSession session, String homework1, String homework2){
        Admin admin = (Admin) session.getAttribute("admin");
        System.out.println(homework1);
        System.out.println(homework2);
        Similar similarity = new Similar(homework1, homework2);
        System.out.println(similarity.sim());
        model.addAttribute("result", similarity.sim());
        session.setAttribute("result", similarity.sim());
        session.setAttribute("homework1", homework1);
        session.setAttribute("homework2", homework2);
        try{

            return "redirect:/teacher_similar";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
