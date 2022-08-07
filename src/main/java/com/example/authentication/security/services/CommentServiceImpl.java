package com.example.authentication.security.services;

import com.example.authentication.models.Comment;
import com.example.authentication.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getcomments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getcomment(long commentId) {
        return commentRepository.findById(commentId).get();
    }

    @Override
    public Comment addcomment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updatecomment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long parseLong) {
        Comment comment = commentRepository.getById(parseLong);
        commentRepository.delete(comment);

    }
}
