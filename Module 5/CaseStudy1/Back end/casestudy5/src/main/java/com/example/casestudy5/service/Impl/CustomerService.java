package com.example.casestudy5.service.Impl;

import com.example.casestudy5.exception.CustomerNotFoundException;
import com.example.casestudy5.model.Item;
import com.example.casestudy5.repository.ICustomerRepository;
import com.example.casestudy5.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
   @Autowired
   private ICustomerRepository iCustomerRepository;

//    @Override
//    public List<Item> findAll() {
//        return iCustomerRepository.findAll();
//    }
//
    @Override
    public void createCustomer(Item item) {
        iCustomerRepository.save(item);
    }
//
    @Override
    public void deleteCustomer(Integer id) {
        iCustomerRepository.deleteById(id);
    }
//
//    @Override
//    public Item findById(Integer id) {
//        return iCustomerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer by id " + id + " was not found"));
//    }
//
//    @Override
//    public void updateCustomer(Item item) {
//        iCustomerRepository.save(item);
//    }

    @Override
    public Page<Item> getAllPaginate(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size,Sort.by("id").descending());
        Page<Item> customers = iCustomerRepository.findAll(paging);
        return customers;
    }
//
    @Override
    public Page<Item> getByName(String name, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Item> customers = iCustomerRepository.findByCodeContaining(name, paging);
        return customers;
    }

//
//    @Override
//    public Page<Item> getByCustomerType(Integer id, Integer page, Integer size) {
//        Pageable paging = PageRequest.of(page, size,Sort.by("id").descending());
//        Page<Item> customers = iCustomerRepository.findByCustomerTypeId(id,paging);
//        return customers;
//    }
//
//    @Override
//    public Page<Item> findByNameAndType(Integer id, String name, Integer page, Integer size) {
//        Pageable paging = PageRequest.of(page, size,Sort.by("id").descending());
//        Page<Item> customers = iCustomerRepository.findByCustomerTypeIdAndNameContaining(id,name,paging);
//        return customers;
//    }


}
