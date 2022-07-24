package com.example.book.service;



import com.example.book.entity.Book;
import com.example.book.entity.Code;
import com.example.book.exception.CodeDoesNotExistException;
import com.example.book.exception.NotEnoughBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    void borrowBook(Book book ,Integer usedCode);

    Code getRandomAvailableCode(Book book) throws NotEnoughBookException;

    void returnBook(Book book, Integer returnCode) throws CodeDoesNotExistException;

    void deleteBook(Integer id);

    Page<Book> fillAll(Pageable pageable);

    Page<Book> searchByTitleAndAuthorAndQuantity(String title, String author, String quantity , Pageable pageable);
}
