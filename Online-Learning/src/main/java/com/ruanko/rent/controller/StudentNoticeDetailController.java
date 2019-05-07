package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentNoticeDetailController {

    @Autowired
    private NoticeService noticeService;


    //跳转到Notice详情界面
    @RequestMapping("/studentShowNoticeDetailInfo")
    public String showStudentNoticeDetailInf(Model model, String id) {
        Notice notice = noticeService.findNoticeById(id);
        model.addAttribute("notice", notice);
        return "student_notice_detail_info";
    }
}
