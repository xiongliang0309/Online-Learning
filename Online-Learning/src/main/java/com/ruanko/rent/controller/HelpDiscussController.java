package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Discuss;
import com.ruanko.rent.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelpDiscussController {
    @Autowired
    private DiscussService discussService;

    //助教论坛显示
    @RequestMapping("/help_discuss")
    public String showHelpDiscussList(Model model) {
        List<Discuss> discussList = discussService.getDiscussList();
        model.addAttribute("discussList", discussList);
        return "help_discuss";
    }
}
