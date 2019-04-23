package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Discuss;
import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.entity.Score;
import com.ruanko.rent.service.DiscussService;
import com.ruanko.rent.service.NoticeService;
import com.ruanko.rent.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherDiscussController {
    @Autowired
    private DiscussService discussService;

    @RequestMapping("/teacher_discuss")
    public String showTeacherDiscussList(Model model) {
        List<Discuss> discussList = discussService.getDiscussList();
        model.addAttribute("discussList", discussList);
        return "teacher_discuss";
    }
}
