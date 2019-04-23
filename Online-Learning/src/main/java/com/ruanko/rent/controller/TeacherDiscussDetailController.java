package com.ruanko.rent.controller;

import com.ruanko.rent.entity.Comment;
import com.ruanko.rent.entity.Discuss;
import com.ruanko.rent.service.DiscussService;
import com.ruanko.rent.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class TeacherDiscussDetailController {
    @Autowired
    private DiscussService discussService;

    @Autowired
    private CommentService commentService;

    //跳转到Notice详情界面
    @RequestMapping("/teacherDiscussDetail")
    public String teacherDiscussDetail(Model model, String discussid) {
        Discuss discuss = discussService.findDiscussById(discussid);
        model.addAttribute("discuss", discuss);
        List<Comment> commentList = commentService.getCommentList();
        model.addAttribute("commentList", commentList);
        return "teacher_discuss_detail";
    }
}
