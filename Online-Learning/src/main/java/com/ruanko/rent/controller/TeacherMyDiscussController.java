package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Discuss;
import com.ruanko.rent.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class TeacherMyDiscussController {
    @Autowired
    private DiscussService discussService;

    @RequestMapping("/teacher_mydiscuss")
    public String showTeacherDiscussList(Model model) {
        List<Discuss> discussList = discussService.getDiscussList();
        model.addAttribute("discussList", discussList);
        return "teacher_mydiscuss";
    }

    //删除论坛
    @RequestMapping("/teacherDeleteDiscuss")
    public String teacherDeleteDiscuss(String discussid){
        discussService.delete(discussid);
        return "redirect:/teacher_mydiscuss";
    }
}
