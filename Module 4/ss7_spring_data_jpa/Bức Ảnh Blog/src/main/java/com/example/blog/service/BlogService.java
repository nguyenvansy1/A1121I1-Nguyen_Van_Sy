package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements  IBlogService{
   @Autowired
   private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }



    @Override
    public void save(Blog blog) {
       iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
       return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchByName(String name , Pageable pageable) {
        return  iBlogRepository.searchByName("%"+name+"%",pageable);
    }
}
