package com.example.casestudy5.repository;

import com.example.casestudy5.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<Product,Integer> {
}
