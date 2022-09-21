package com.example.casestudy5.service.Impl;

import com.example.casestudy5.model.CustomerType;
import com.example.casestudy5.repository.ICustomerTypeRepository;
import com.example.casestudy5.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
