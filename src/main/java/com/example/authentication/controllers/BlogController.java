package com.example.authentication.controllers;

import com.example.authentication.models.Blog;
import com.example.authentication.security.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BlogController {
    
    @Autowired
    private BlogService blogService;
    
    @GetMapping("/blogs")
    public List<Blog> getBlogs(){
        return this.blogService.getBlogs();
    }

    @GetMapping("/blogs/{blogId}")
    public Blog getBlog(@PathVariable String blogId){
        return this.blogService.getBlog(Long.parseLong(blogId));
    }

    @PostMapping("/blogs")
    public Blog addBlog(@RequestBody Blog blog){
        return this.blogService.addBlog(blog);
    }

    @PutMapping("/blogs")
    public Blog updateblog(@RequestBody Blog blog){
        return this.blogService.updateBlog(blog);
    }

    @DeleteMapping("/blogs/{blogId}")
    public ResponseEntity<HttpStatus> deleteblog(@PathVariable String blogId) {
        try {
            this.blogService.deleteBlog(Long.parseLong(blogId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
