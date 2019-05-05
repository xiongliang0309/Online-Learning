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
public class TeacherDiscussDetailController {
    @Autowired
    private DiscussService discussService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private Comment comment;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    //跳转到Discuss详情界面
    @RequestMapping("/teacherDiscussDetail")
    public String teacherDiscussDetail(Model model, String discussid) {
        Discuss discuss = discussService.findDiscussById(discussid);
        model.addAttribute("discuss", discuss);
        List<Comment> commentList = commentService.getCommentList();
        model.addAttribute("commentList", commentList);
        return "teacher_discuss_detail";
    }

    //添加留言
    @RequestMapping(value = "/addComment.action", method = POST)
    public String addToClass(HttpSession session,String discussid, String commentcontent) {

        Admin admin = (Admin) session.getAttribute("admin");
        comment.setCommentcontent(commentcontent);
        comment.setDiscussid(discussid);
        comment.setCommentdate(sdf.format(new Date()));
        comment.setCommenter(admin.getName());
        //保存到数据库
        try{
            commentService.save(comment);
            return "redirect:/teacherDiscussDetail?discussid="+discussid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //删除留言
    @RequestMapping("/teacherDeleteComment")
    public String teacherDeleteDiscuss(String commentid,String discussid){
        commentService.delete(commentid);
        return "redirect:/teacherDiscussDetail?discussid="+discussid;
    }
}
