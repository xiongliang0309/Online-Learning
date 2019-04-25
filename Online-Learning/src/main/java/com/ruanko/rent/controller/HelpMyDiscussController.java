package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Discuss;
import com.ruanko.rent.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class HelpMyDiscussController {
    @Autowired
    private DiscussService discussService;

    @RequestMapping("/help_mydiscuss")
    public String showStudentDiscussList(Model model) {
        List<Discuss> discussList = discussService.getDiscussList();
        model.addAttribute("discussList", discussList);
        return "help_mydiscuss";
    }

    //删除论坛
    @RequestMapping("/helpDeleteDiscuss")
    public String studentDeleteDiscuss(String discussid){
        discussService.delete(discussid);
        return "redirect:/help_mydiscuss";
    }
}
