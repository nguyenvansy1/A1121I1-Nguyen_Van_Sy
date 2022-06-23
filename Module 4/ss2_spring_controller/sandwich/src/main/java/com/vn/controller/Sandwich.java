package com.vn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sandwich {


    @GetMapping("/save")
    public String sandwich(){
        return "sandwich";
    }


    @PostMapping("/save")
    public String result(@RequestParam(value = "check") String[] list , Model model){
        model.addAttribute("list",list);
        return "sandwich";
    }

}
