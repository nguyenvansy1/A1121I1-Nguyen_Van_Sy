package com.vn.service;



import com.vn.model.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EmailService implements IEmailService {
    private static Map<Integer, Email> emailList;

    static {
        emailList = new HashMap<>();
        emailList.put(1, new Email(1, "English", 25, true, "Thor"));
        emailList.put(2, new Email(2, "Vietnamese", 15, false, "Zeus"));
        emailList.put(3, new Email(3, "Japanese", 10, true, "Hera"));
    }

    public List<Email> showAll() {
        return new ArrayList<>(emailList.values());
    }

    public Email findById(Integer id) {
        return emailList.get(id);
    }

    public void update(Email email) {
        emailList.put(email.getId(), email);
    }
}
