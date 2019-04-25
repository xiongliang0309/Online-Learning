package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Discuss;
import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.service.AdminService;
import com.ruanko.rent.service.DiscussService;
import com.ruanko.rent.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherAddDiscussController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private DiscussService discussService;
    @Autowired
    private Discuss discuss;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/teacher_adddiscuss")
    public String showTeacherAddDiscuss() {
        return "teacher_adddiscuss";
    }

    @RequestMapping(value="/teacherAddDiscuss.action", method = POST)
    public String teacherAddDiscuss(HttpSession session, String discusstitle, String discusscontent){
        Admin admin = (Admin) session.getAttribute("admin");
        discuss.setDiscusstitle(discusstitle);
        discuss.setDiscusscontent(discusscontent);
        discuss.setDiscusser(admin.getName());
        discuss.setDiscussdate(sdf.format(new Date()));

        //保存到数据库
        try{
            discussService.save(discuss);
            return "redirect:/teacher_discuss";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
