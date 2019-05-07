package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Admin;
import com.ruanko.rent.entity.Classes;
import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.service.ClassesService;
import com.ruanko.rent.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherNoticeListController {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ClassesService classesService;

    @Autowired
    private Notice notice;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //教师通知列表
    @RequestMapping("/teacher_notice")
    public String showTeacherNoticeList(Model model) {
        List<Notice> noticeList = noticeService.getNoticeList();
        model.addAttribute("noticeList", noticeList);
        List<Classes> classesList = classesService.getClassesList();
        model.addAttribute("classesList", classesList);
        return "teacher_notice";
    }
    //删除通知
    @RequestMapping("/teacherDeleteNotice")
    public String teacherDeleteNotice(String id){
        noticeService.delete(id);
        return "redirect:/teacher_notice";
    }

    @RequestMapping(value="/teacherAddNotice.action", method = POST)
    public String teacherAddNotice(HttpSession session, String title, String content, String classid){
        Admin admin = (Admin) session.getAttribute("admin");
        notice.setTitle(title);
        notice.setContent(content);
        notice.setNoticer(admin.getName());
        notice.setNoticedate(sdf.format(new Date()));
        notice.setClassid(classid);

        //保存到数据库
        try{
            noticeService.save(notice);
            return "redirect:/teacher_notice";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
