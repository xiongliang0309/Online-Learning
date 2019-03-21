package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Score;
import com.ruanko.rent.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherCalculateController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/teacher_calculate")
    public String showStudentScoreList(Model model) {
        List<Score> scoreList = scoreService.getScoreList();
        model.addAttribute("scoreList", scoreList);
        return "teacher_calculate";
    }
}
