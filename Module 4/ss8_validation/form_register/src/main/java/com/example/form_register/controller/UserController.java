package com.example.form_register.controller;

import com.example.form_register.entity.User;
import com.example.form_register.service.IUserService;
import com.example.form_register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String home(Model model)
    {
        model.addAttribute("userList",userService.fillAll());
        return "list";
    }

    @GetMapping("/create")
    public String createHome(Model model){
        model.addAttribute("user" , new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User user , BindingResult bindingResult)
    {
        new User().validate(user,bindingResult);
        if (bindingResult.hasErrors())
        {
            return "create";
        }
        userService.save(user);
        return  "redirect:/list";

    }

}
