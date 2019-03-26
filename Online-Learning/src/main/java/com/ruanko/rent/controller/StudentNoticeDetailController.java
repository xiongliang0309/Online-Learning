package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.entity.Order;
import com.ruanko.rent.service.HouseService;
import com.ruanko.rent.service.NoticeService;
import com.ruanko.rent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class StudentNoticeDetailController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private Order order;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    //跳转到Notice详情界面
    @RequestMapping("/studentShowNoticeDetailInfo")
    public String showStudentNoticeDetailInf(Model model, String id) {
        Notice notice = noticeService.findNoticeById(id);
        model.addAttribute("notice", notice);
        return "student_notice_detail_info";
    }
}
