package com.example.authentication.controllers;

import com.example.authentication.models.Comment;
import com.example.authentication.security.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getComments(){
        return this.commentService.getcomments();
    }

    @GetMapping("/comments/{commentId}")
    public Comment getComment(@PathVariable String commentId){
        return this.commentService.getcomment(Long.parseLong(commentId));
    }

    @PostMapping("/comments")
    public Comment addcomment(@RequestBody Comment comment){
        return this.commentService.addcomment(comment);
    }

    @PutMapping("/comments")
    public Comment updatecomment(@RequestBody Comment comment){
        return this.commentService.updatecomment(comment);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<HttpStatus> deletecomment(@PathVariable String commentId) {
        try {
            this.commentService.deleteComment(Long.parseLong(commentId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
