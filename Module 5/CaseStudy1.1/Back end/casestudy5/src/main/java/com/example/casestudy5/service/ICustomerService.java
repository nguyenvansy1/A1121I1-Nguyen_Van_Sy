package com.example.casestudy5.service;

import com.example.casestudy5.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> fillAll();

    void createCustomer(Customer customer);
}
