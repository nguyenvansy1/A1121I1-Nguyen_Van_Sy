package com.vn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {


    @GetMapping("/calculator")
    public String calculator(){
        return "calculator";
    }


    @PostMapping("/calculator")
    public String result(@RequestParam("math") String math ,@RequestParam("x1") int x1, @RequestParam("x2") int x2,Model model){
        String result = "";
        if (math.equals("+"))
        {
            result = x1+x2+"";
            model.addAttribute("math","Addition");
        }
        if (math.equals("-"))
        {
            result = x1-x2+"";
            model.addAttribute("math","Subtraction");
        }
        if (math.equals("*"))
        {
            result = x1*x2+"";
            model.addAttribute("math","Multiplication");
        }
        if (math.equals("/"))
        {
           if (x2==0)
           {
               result = "";
               model.addAttribute("mess","Cannot be divided by 0");
               model.addAttribute("math","Division");
           }
           else
           {
               result = x1/x2+"";
               model.addAttribute("math","Division");
           }
        }
        model.addAttribute("x1",x1);
        model.addAttribute("x2",x2);
        model.addAttribute("result",result);
        return "calculator";
    }

}
