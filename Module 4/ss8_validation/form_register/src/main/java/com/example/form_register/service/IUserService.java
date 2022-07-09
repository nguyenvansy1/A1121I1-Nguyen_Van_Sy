package com.example.form_register.service;

import com.example.form_register.entity.User;

import java.util.List;

public interface IUserService {
    List<User> fillAll();

    void save(User user);
}
