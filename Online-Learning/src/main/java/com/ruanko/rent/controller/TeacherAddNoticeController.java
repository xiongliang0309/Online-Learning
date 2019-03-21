package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherAddNoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/teacher_addnotice")
    public String showStudentNoticeList(Model model) {

        return "teacher_addnotice";
    }
}