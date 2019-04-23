package com.ruanko.rent.service;

import com.ruanko.rent.dao.CommentDao;
import com.ruanko.rent.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    public List<Comment> getCommentList(){
        return commentDao.getAll();
    }

    public Comment findCommentById(String commentid){
        return  commentDao.getOne(commentid);
    }

    public void save(Comment comment) {
        commentDao.insert(comment);
    }

    public void edit(Comment comment){
        commentDao.update(comment);
    }

    public void delete(String commentid) {
        commentDao.delete(commentid);
    }
}
