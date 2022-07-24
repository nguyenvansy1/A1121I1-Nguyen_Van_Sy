package com.example.book.repository;


import com.example.book.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICodeRepository extends JpaRepository<Code,Integer> {
    @Query(value = "select * from code where book_id = :book" , nativeQuery = true)
    List<Code> findCodeByBookId(@Param("book") Integer id);

    @Query(value = "select * from code where book_id = :book and status_id = :status" , nativeQuery = true)
    List<Code> findCodeByBookAndStatus(@Param("book") Integer bookId,@Param("status") Integer statusId);
}
