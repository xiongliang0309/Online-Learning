package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Studydata;
import com.ruanko.rent.service.StudydataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherStudyDataController {
    @Autowired
    private StudydataService studydataService;

    //teacher_studydata.html资料显示
    @RequestMapping("/teacher_studydata")
    public String showTeacherStudydata(Model model) {
        List<Studydata> studydataList = studydataService.getStudydataList();
        model.addAttribute("studydataList", studydataList);
        return "teacher_studydata";
    }


}
