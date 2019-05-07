package com.ruanko.rent.controller;

import com.ruanko.rent.entity.*;
import com.ruanko.rent.service.AdminService;
import com.ruanko.rent.service.DiscussService;
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
public class OfficeDiscussController {
    @Autowired
    private DiscussService discussService;

    @Autowired
    private Discuss discuss;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //显示论坛
    @RequestMapping("/office_discuss")
    public String showDiscussList(Model model) {
        List<Discuss> discussList = discussService.getDiscussList();
        model.addAttribute("discussList", discussList);
        return "office_discuss";
    }

    //删除论坛
    @RequestMapping("/officeDeleteDiscuss")
    public String officeDeleteDiscuss(String discussid){
        discussService.delete(discussid);
        return "redirect:/office_discuss";
    }

    //发起论坛
    @RequestMapping(value="/officeAddDiscuss.action", method = POST)
    public String teacherAddDiscuss(HttpSession session, String discusstitle, String discusscontent){
        Office office = (Office) session.getAttribute("office");
        discuss.setDiscusstitle(discusstitle);
        discuss.setDiscusscontent(discusscontent);
        discuss.setDiscusser(office.getName());
        discuss.setDiscussdate(sdf.format(new Date()));

        //保存到数据库
        try{
            discussService.save(discuss);
            return "redirect:/office_discuss";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
