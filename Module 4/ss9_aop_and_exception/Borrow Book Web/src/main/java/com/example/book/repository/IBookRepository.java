package com.example.book.repository;

import com.example.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book where title like :title and author like :author and quantity like :quantity" , nativeQuery = true)
    Page<Book> searchByTitleAndAuthorAndQuantity(@Param("title") String title, @Param("author") String author, @Param("quantity") String quantity, Pageable pageable);
}
