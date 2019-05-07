//package com.ruanko.rent.controller;
//
//import com.ruanko.rent.entity.Classes;
//import com.ruanko.rent.entity.Notice;
//import com.ruanko.rent.entity.Admin;
//import com.ruanko.rent.service.ClassesService;
//import org.springframework.ui.Model;
//import com.ruanko.rent.service.AdminService;
//import com.ruanko.rent.service.NoticeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import static org.springframework.web.bind.annotation.RequestMethod.POST;
//
//@Controller
//public class TeacherAddNoticeController {
//    @Autowired
//    private ClassesService classesService;
//    @Autowired
//    private NoticeService noticeService;
//    @Autowired
//    private Notice notice;
//
//    private Date date = new Date();
//    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//    @RequestMapping("/teacher_notice")
//    public String showTeacherAddNotice1(Model model) {
//        List<Classes> classesList = classesService.getClassesList();
//        model.addAttribute("classesList", classesList);
//        return "teacher_notice";
//    }
//
//    @RequestMapping(value="/teacherAddNotice.action", method = POST)
//    public String teacherAddNotice(HttpSession session, String title, String content,String classid){
//        Admin admin = (Admin) session.getAttribute("admin");
//        notice.setTitle(title);
//        notice.setContent(content);
//        notice.setNoticer(admin.getName());
//        notice.setNoticedate(sdf.format(date));
//        notice.setClassid(classid);
//
//        //保存到数据库
//        try{
//            noticeService.save(notice);
//            return "redirect:/teacher_notice";
//        }catch(Exception e) {
//            System.out.print(e);
//            return "error";
//        }
//    }
//}
