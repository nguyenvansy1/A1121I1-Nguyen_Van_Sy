package com.vn.service;



import com.vn.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> showAll();
    Email findById(Integer id);
    void update(Email email);
}
