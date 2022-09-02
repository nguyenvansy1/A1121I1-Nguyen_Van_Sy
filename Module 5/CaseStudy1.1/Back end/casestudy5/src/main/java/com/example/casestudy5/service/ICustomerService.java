package com.example.casestudy5.service;

import com.example.casestudy5.model.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Page<Customer> getAllPaginate(Integer page, Integer size);

    void createCustomer(Customer customer);

    void deleteCustomer(Integer id);

    Customer findById(Integer id);

    void updateCustomer(Customer customer);

    Page<Customer> getByName(String name, Integer page, Integer size);

    Page<Customer> getByCustomerType(Integer id, Integer page, Integer size);

    Page<Customer> findByNameAndType(Integer id, String name, Integer page, Integer size);
}
