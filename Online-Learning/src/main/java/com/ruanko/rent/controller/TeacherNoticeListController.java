package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherNoticeListController {
    @Autowired
    private NoticeService noticeService;
    //教师通知列表
    @RequestMapping("/teacher_notice")
    public String showTeacherNoticeList(Model model) {
        List<Notice> noticeList = noticeService.getNoticeList();
        model.addAttribute("noticeList", noticeList);
        return "teacher_notice";
    }
    //删除通知
    @RequestMapping("/teacherDeleteNotice")
    public String teacherDeleteNotice(String id){
        noticeService.delete(id);
        return "redirect:/teacher_notice";
    }
}
