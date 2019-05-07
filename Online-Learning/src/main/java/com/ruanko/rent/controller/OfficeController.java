package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OfficeController {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private LeaseholderService leaseholderService;
    @Autowired
    private LandlordService landlordService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private DiscussService discussService;
    @Autowired
    private KechenService kechenService;

    //跳转到教务页面
    @RequestMapping("/office")
    public String showOfficePage(Model model) {
        //office.html显示系统总览
        int studentNum = leaseholderService.getLeaseholderList().size();
        model.addAttribute("studentNum", studentNum);

        int helpNum = landlordService.getLandlordList().size();
        model.addAttribute("helpNum", helpNum);

        int noticeNum=noticeService.getNoticeList().size();
        model.addAttribute("noticeNum",noticeNum);

        int teacherNum=adminService.getAdminList().size();
        model.addAttribute("teacherNum",teacherNum);

        int discussNum=discussService.getDiscussList().size();
        model.addAttribute("discussNum",discussNum);

        int kechenNum=kechenService.getKechenList().size();
        model.addAttribute("kechenNum",kechenNum);

        List<Notice> noticeList = noticeService.getNoticeList();
        model.addAttribute("noticeList", noticeList);
        return "office";
    }

    //跳转到office_help页面
    @RequestMapping("/office_help")
    public String showLeaseholderHelpPage() {
        return "office_help";
    }
}
