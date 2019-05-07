package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Discuss;
import com.ruanko.rent.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class StudentMyDiscussController {
    @Autowired
    private DiscussService discussService;

    //学生我的论坛显示
    @RequestMapping("/student_mydiscuss")
    public String showStudentDiscussList(Model model) {
        List<Discuss> discussList = discussService.getDiscussList();
        model.addAttribute("discussList", discussList);
        return "student_mydiscuss";
    }

    //删除论坛
    @RequestMapping("/studentDeleteDiscuss")
    public String studentDeleteDiscuss(String discussid){
        discussService.delete(discussid);
        return "redirect:/student_mydiscuss";
    }
}
