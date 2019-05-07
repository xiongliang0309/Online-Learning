package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Discuss;
import com.ruanko.rent.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.List;


@Controller
public class StudentDiscussController {
    @Autowired
    private DiscussService discussService;

    //显示学生讨论
    @RequestMapping("/student_discuss")
    public String showStudentDiscussList(Model model) {
        List<Discuss> discussList = discussService.getDiscussList();
        model.addAttribute("discussList", discussList);
        return "student_discuss";
    }


}
