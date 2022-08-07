package com.example.authentication.security.services;

import com.example.authentication.models.Blog;
import com.example.authentication.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlog(long blogId) {
        return blogRepository.findById(blogId).get();
    }

    @Override
    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Long parseLong) {
        Blog blog = blogRepository.getById(parseLong);
        blogRepository.delete(blog);

    }
}
