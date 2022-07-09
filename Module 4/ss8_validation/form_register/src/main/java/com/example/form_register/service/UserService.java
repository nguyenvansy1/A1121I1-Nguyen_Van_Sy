package com.example.form_register.service;

import com.example.form_register.entity.User;
import com.example.form_register.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
   @Autowired
   private IUserRepository iUserRepository;

    @Override
    public List<User> fillAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user) ;
    }
}
