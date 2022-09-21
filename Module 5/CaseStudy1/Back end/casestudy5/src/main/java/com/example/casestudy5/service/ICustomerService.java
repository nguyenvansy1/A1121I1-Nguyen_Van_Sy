package com.example.casestudy5.service;

import com.example.casestudy5.model.Item;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerService {

    Page<Item> getAllPaginate(Integer page, Integer size);

    void createCustomer(Item item) ;
//
    void deleteCustomer(Integer id);
//
//    Item findById(Integer id);
//
//    void updateCustomer(Item item);
//
    Page<Item> getByName(String name, Integer page, Integer size);
//
//    Page<Item> getByCustomerType(Integer id, Integer page, Integer size);
//
//    Page<Item> findByNameAndType(Integer id, String name, Integer page, Integer size);
}
