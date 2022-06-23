package com.vn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {

    @GetMapping("/dictionary")
    public String dictionary() {
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String convert(@RequestParam(value = "eng") String eng, Model model) {
        switch(eng){
            case "red": model.addAttribute("result","đỏ");
            break;
            case "blue": model.addAttribute("result","xanh");
                break;
            case "white": model.addAttribute("result","trắng");
                break;
            case "black": model.addAttribute("result","đen");
                break;
            default: model.addAttribute("mess","không tìm thấy kết quả")    ;
        }
        return "dictionary";
    }
}
