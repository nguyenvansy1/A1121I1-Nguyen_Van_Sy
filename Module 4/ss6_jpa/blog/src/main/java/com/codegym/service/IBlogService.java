package com.codegym.service;

import com.codegym.entity.Blog;

import java.util.List;

public interface IBlogService {
    void create(Blog blog);
    void update(Blog blog);
    void delete(Integer id);
    List<Blog> findAll();
    Blog findById(Integer id);

}
