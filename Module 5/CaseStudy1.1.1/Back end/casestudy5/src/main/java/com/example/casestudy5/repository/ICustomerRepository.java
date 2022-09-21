package com.example.casestudy5.repository;

import com.example.casestudy5.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByNameContaining(String name, Pageable pageable);

    Page<Customer> findByCustomerTypeId(Integer id, Pageable pageable);

    Page<Customer> findByCustomerTypeIdAndNameContaining(Integer id, String name, Pageable pageable);
}
