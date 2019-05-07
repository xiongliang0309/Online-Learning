package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Classes;
import com.ruanko.rent.entity.Notice;
import com.ruanko.rent.entity.Office;
import com.ruanko.rent.service.ClassesService;
import com.ruanko.rent.service.NoticeService;
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
public class OfficeNoticeController {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private Notice notice;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //显示通知
    @RequestMapping("/office_notice")
    public String showOfficeNoticeList(Model model) {
        List<Notice> noticeList = noticeService.getNoticeList();
        model.addAttribute("noticeList", noticeList);
        List<Classes> classesList = classesService.getClassesList();
        model.addAttribute("classesList", classesList);
        return "office_notice";
    }

    //跳转到Notice详情界面
    @RequestMapping("/officeShowNoticeDetailInfo")
    public String showOfficeNoticeDetailInf(Model model, String id) {
        Notice notice = noticeService.findNoticeById(id);
        model.addAttribute("notice", notice);
        return "office_notice_detail";
    }

    //删除通知
    @RequestMapping("/officeDeleteNotice")
    public String officeDeleteNotice(String id){
        noticeService.delete(id);
        return "redirect:/office_notice";
    }

    //office发布通知
    @RequestMapping(value="/officeAddNotice.action", method = POST)
    public String officeAddNotice(HttpSession session, String title, String content, String classid){
        Office office = (Office) session.getAttribute("office");
        notice.setTitle(title);
        notice.setContent(content);
        notice.setNoticer(office.getName());
        notice.setNoticedate(sdf.format(new Date()));
        notice.setClassid(classid);

        //保存到数据库
        try{
            noticeService.save(notice);
            return "redirect:/office_notice";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
