package com.example.casestudy5.service;

import com.example.casestudy5.model.Customer;
import com.example.casestudy5.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
