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
public class OfficeDiscussDetailController {
    @Autowired
    private DiscussService discussService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private Comment comment;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    //跳转到discuss详情界面
    @RequestMapping("/officeDiscussDetail")
    public String studentDiscussDetail(Model model, String discussid) {
        Discuss discuss = discussService.findDiscussById(discussid);
        model.addAttribute("discuss", discuss);
        List<Comment> commentList = commentService.getCommentList();
        model.addAttribute("commentList", commentList);
        return "office_discuss_detail";
    }

    //添加留言
    @RequestMapping(value = "/officeAddComment.action", method = POST)
    public String addToClass(HttpSession session,String discussid, String commentcontent) {

        Office office = (Office) session.getAttribute("office");
        comment.setCommentcontent(commentcontent);
        comment.setDiscussid(discussid);
        comment.setCommentdate(sdf.format(new Date()));
        comment.setCommenter(office.getName());
        //保存到数据库
        try{
            commentService.save(comment);
            return "redirect:/officeDiscussDetail?discussid="+discussid;
        }catch(Exception e) {
            System.out.print(e);
            return "error";
        }
    }

    //删除留言
    @RequestMapping("/officeDeleteComment")
    public String officeDeleteComment(String commentid,String discussid){
        commentService.delete(commentid);
        return "redirect:/officeDiscussDetail?discussid="+discussid;
    }
}
