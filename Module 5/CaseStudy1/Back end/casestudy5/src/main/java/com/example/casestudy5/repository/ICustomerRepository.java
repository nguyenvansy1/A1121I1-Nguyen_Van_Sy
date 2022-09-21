package com.example.casestudy5.repository;

import com.example.casestudy5.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Item,Integer> {

    Page<Item> findAll(Pageable pageable);
//
    Page<Item> findByCodeContaining(String name, Pageable pageable);
//
//    Page<Item> findByProductNameContaining(Integer id, Pageable pageable);
//
//    Page<Item> findByCustomerTypeIdAndNameContaining(Integer id, String name, Pageable pageable);
}
