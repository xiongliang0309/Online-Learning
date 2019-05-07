package com.ruanko.rent.controller;

import com.ruanko.rent.entity.*;
import com.ruanko.rent.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HelpAddDiscussController {

    @Autowired
    private DiscussService discussService;
    @Autowired
    private Discuss discuss;


    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    //助教发布论坛
    @RequestMapping(value="/helpAddDiscuss.action", method = POST)
    public String teacherAddDiscuss(HttpSession session, String discusstitle, String discusscontent){
        Landlord landlord = (Landlord) session.getAttribute("landlord");
        discuss.setDiscusstitle(discusstitle);
        discuss.setDiscusscontent(discusscontent);
        discuss.setDiscusser(landlord.getName());
        discuss.setDiscussdate(sdf.format(new Date()));

        //保存到数据库
        try{
            discussService.save(discuss);
            return "redirect:/help_discuss";
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }
}
