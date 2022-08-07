package com.example.authentication.security.services;

import com.example.authentication.models.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getcomments();

    public Comment getcomment(long commentId);

    public Comment addcomment(Comment comment);

    public Comment updatecomment(Comment comment);

    public void deleteComment(Long parseLong);
}
