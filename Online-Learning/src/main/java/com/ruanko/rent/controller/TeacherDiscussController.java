package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Discuss;
import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.entity.Score;
import com.ruanko.rent.service.AdminService;
import com.ruanko.rent.service.DiscussService;
import com.ruanko.rent.service.NoticeService;
import com.ruanko.rent.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherDiscussController {
    @Autowired
    private DiscussService discussService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private Discuss discuss;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/teacher_discuss")
    public String showTeacherDiscussList(Model model) {
        List<Discuss> discussList = discussService.getDiscussList();
        model.addAttribute("discussList", discussList);
        return "teacher_discuss";
    }

}
