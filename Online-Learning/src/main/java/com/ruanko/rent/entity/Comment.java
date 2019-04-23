package com.ruanko.rent.entity;

import org.springframework.stereotype.Component;

@Component
public class Comment {
    private String commentid;
    private String commenter;
    private String commentcontent;
    private String commentdate;
    private String discussid;

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate;
    }

    public String getDiscussid() {
        return discussid;
    }

    public void setDiscussid(String discussid) {
        this.discussid = discussid;
    }

    public Comment() {
        super();
    }



    @Override
    public String toString() {
        return "Comment{" +
                "commentid='" + commentid + '\'' +
                ", commenter='" + commenter + '\'' +
                ", commentcontent='" + commentcontent + '\'' +
                ", commentdate='" + commentdate + '\'' +
                ", discussid='" + discussid + '\'' +
                '}';
    }
}
