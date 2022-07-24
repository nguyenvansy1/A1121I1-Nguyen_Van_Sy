package com.example.blog.controller;


import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private  BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String list(Model model,@RequestParam(value = "page" , defaultValue = "0") int page)
    {
        model.addAttribute("blog", blogService.findAll(PageRequest.of(page,5 ,Sort.by("year"))));
        return  "list";
    }

    @GetMapping("/create")
    public  String viewCreate(Model model)
    {
        model.addAttribute("category",categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id)
    {
        blogService.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String editView(@RequestParam("id") int id,Model model)
    {
        model.addAttribute("category",categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "redirect:/list";
    }


    @GetMapping("/list/search")
    public String search(@RequestParam("name") String name, @RequestParam(value = "page" , defaultValue = "0") int page , Model model)
    {

        Page<Blog> blog = blogService.searchByName(name , PageRequest.of(page,5));
        model.addAttribute("name" , name);
        model.addAttribute("blog", blog);
        return "list";
    }
}


