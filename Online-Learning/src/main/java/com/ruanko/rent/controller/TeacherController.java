package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.service.AdminService;
import com.ruanko.rent.service.NoticeService;
import com.ruanko.rent.service.LandlordService;
import com.ruanko.rent.service.LeaseholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private LeaseholderService leaseholderService;
    @Autowired
    private LandlordService landlordService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/teacher")
    public String showTeacherPage(Model model) {

        //teacher.html显示系统总览
        int leaseholderNum = leaseholderService.getLeaseholderList().size();
        model.addAttribute("leaseholderNum", leaseholderNum);

        int landlordNum = landlordService.getLandlordList().size();
        model.addAttribute("landlordNum", landlordNum);

        int noticeNum=noticeService.getNoticeList().size();
        model.addAttribute("noticeNum",noticeNum);

        int adminNum=adminService.getAdminList().size();
        model.addAttribute("adminNum",adminNum);

        List<Notice> noticeList=noticeService.getNoticeList();
        model.addAttribute("noticeList",noticeList);

        return "teacher";
    }

    //跳转到teacher_help页面
    @RequestMapping("/teacher_help")
    public String showTeacherHelpPage() {
        return "teacher_help";
    }

}
