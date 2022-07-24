package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        blogService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model)
    {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog) {
        blogService.create(blog);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog) {
        blogService.update(blog);
        return "redirect:/list";
    }



}
