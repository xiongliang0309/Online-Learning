package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherStudyDataController {
    @Autowired
    private AdminService adminService;

    //teacher_studydata.html 学习资料上传下载
    @RequestMapping("/teacher_studydata")
    public String showAdminAdminInfoPage(Model model) {
        List<Admin> adminList = adminService.getAdminList();
        model.addAttribute("adminList", adminList);
        return "teacher_studydata";
    }
}
