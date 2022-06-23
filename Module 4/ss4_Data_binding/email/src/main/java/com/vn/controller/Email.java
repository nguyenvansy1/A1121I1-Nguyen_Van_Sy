package com.vn.controller;


import com.vn.Entity.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Email {


    @GetMapping("/email")
    public String convert(Model model){
        String[] language ={"English","Vietnamese","Japanese","Chinese"};
        Integer[] page = {5,10,15,25,50,100};
        model.addAttribute("email",new EmailService());
        model.addAttribute("page",page);
        model.addAttribute("language1",language);
        return "email";
    }


    @PostMapping("/email")
    public String result(@ModelAttribute EmailService email, Model model){
        String[] language ={"English","Vietnamese","Japanese","Chinese"};
        Integer[] page = {5,10,15,25,50,100};
        model.addAttribute("page",page);
        model.addAttribute("language1",language);
        model.addAttribute("email1",email);
        return "email";
    }
}
