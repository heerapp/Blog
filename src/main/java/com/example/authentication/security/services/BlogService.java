package com.example.authentication.security.services;

import com.example.authentication.models.Blog;

import java.util.List;

public interface BlogService {

    public List<Blog> getBlogs();

    public Blog getBlog(long blogId);

    public Blog addBlog(Blog blog);

    public Blog updateBlog(Blog blog);

    public void deleteBlog(Long parseLong);
}
