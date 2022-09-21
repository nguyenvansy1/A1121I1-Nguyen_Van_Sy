package com.example.casestudy5.service.Impl;

import com.example.casestudy5.exception.CustomerNotFoundException;
import com.example.casestudy5.model.Customer;
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

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer by id " + id + " was not found"));
    }

    @Override
    public void updateCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> getAllPaginate(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size,Sort.by("id").descending());
        Page<Customer> customers = iCustomerRepository.findAll(paging);
        return customers;
    }

    @Override
    public Page<Customer> getByName(String name, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Customer> customers = iCustomerRepository.findByNameContaining(name, paging);
        return customers;
    }

    @Override
    public Page<Customer> getByCustomerType(Integer id, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size,Sort.by("id").descending());
        Page<Customer> customers = iCustomerRepository.findByCustomerTypeId(id,paging);
        return customers;
    }

    @Override
    public Page<Customer> findByNameAndType(Integer id, String name, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size,Sort.by("id").descending());
        Page<Customer> customers = iCustomerRepository.findByCustomerTypeIdAndNameContaining(id,name,paging);
        return customers;
    }


}
