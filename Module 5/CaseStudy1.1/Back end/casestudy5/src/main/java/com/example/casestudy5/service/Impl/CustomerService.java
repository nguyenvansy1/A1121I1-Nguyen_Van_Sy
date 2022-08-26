package com.example.casestudy5.service.Impl;

import com.example.casestudy5.model.Customer;
import com.example.casestudy5.repository.ICustomerRepository;
import com.example.casestudy5.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
   @Autowired
   private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> fillAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }


}
