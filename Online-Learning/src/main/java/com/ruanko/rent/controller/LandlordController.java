package com.ruanko.rent.controller;

import com.ruanko.rent.entity.House;
import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LandlordController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private NoticeService noticeService;

    //跳转到landlord页面
    @RequestMapping("/landlord")
    public String showLandlordPage(Model model) {
        List<Notice> noticeList=noticeService.getNoticeList();
        model.addAttribute("noticeList",noticeList);
        return "landlord";
    }

    //跳转到landlord_help页面
    @RequestMapping("/landlord_help")
    public String showLandlordHelpPage() {
        return "landlord_help";
    }
}