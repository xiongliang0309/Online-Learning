package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private NoticeService noticeService;

    //跳转到leaseholder页面
    @RequestMapping("/student")
    public String showLeaseholderPage(Model model) {
        List<Notice> noticeList = noticeService.getNoticeList();
        model.addAttribute("noticeList", noticeList);
        return "student";
    }

    //跳转到leaseholder_help页面
    @RequestMapping("/student_help")
    public String showLeaseholderHelpPage() {
        return "student_help";
    }
}
