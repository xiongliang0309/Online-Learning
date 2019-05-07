package com.ruanko.rent.controller;

import com.ruanko.rent.entity.*;
import com.ruanko.rent.service.DiscussService;
import com.ruanko.rent.service.CommentService;
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
public class StudentDiscussDetailController {
    @Autowired
    private DiscussService discussService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private Comment comment;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    //跳转到discuss详情界面
    @RequestMapping("/studentDiscussDetail")
    public String studentDiscussDetail(Model model, String discussid) {
        Discuss discuss = discussService.findDiscussById(discussid);
        model.addAttribute("discuss", discuss);
        List<Comment> commentList = commentService.getCommentList();
        model.addAttribute("commentList", commentList);
        return "student_discuss_detail";
    }

    //添加留言
    @RequestMapping(value = "/studentAddComment.action", method = POST)
    public String addToClass(HttpSession session,String discussid, String commentcontent) {

        Leaseholder leaseholder = (Leaseholder) session.getAttribute("leaseholder");
        comment.setCommentcontent(commentcontent);
        comment.setDiscussid(discussid);
        comment.setCommentdate(sdf.format(new Date()));
        comment.setCommenter(leaseholder.getName());
        //保存到数据库
        try{
            commentService.save(comment);
            return "redirect:/studentDiscussDetail?discussid="+discussid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //删除留言
    @RequestMapping("/studentDeleteComment")
    public String studentDeleteComment(String commentid,String discussid){
        commentService.delete(commentid);
        return "redirect:/studentDiscussDetail?discussid="+discussid;
    }
}
