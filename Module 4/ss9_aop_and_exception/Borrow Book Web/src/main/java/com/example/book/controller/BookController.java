package com.example.book.controller;


import com.example.book.entity.Book;
import com.example.book.exception.CodeDoesNotExistException;
import com.example.book.exception.NotEnoughBookException;
import com.example.book.service.IBookService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;


    public String homepage(){
        return "index";
    }

    @GetMapping("/book")
    public String viewBook(Model model){
        model.addAttribute("bookList", bookService.findAll());
        return "book/view";
    }

    @GetMapping("/book-page")
    public String viewPage(Model model, @RequestParam(value = "page" , defaultValue = "0") int page){
        Page<Book> bookPage = bookService.fillAll(PageRequest.of(page,5));
        model.addAttribute("bookPage", bookPage);
        return "book/view_page";
    }

    @GetMapping("/book-page/create")
    public String createView(Model model){
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping("/book-page/create")
    public String createBook(@Valid @ModelAttribute("book") Book book , BindingResult bindingResult){
        new Book().validate(book,bindingResult);
        if (bindingResult.hasErrors())
        {
            return "book/create";
        }
        bookService.save(book);
        return "redirect:/book-page";
    }

    @GetMapping("/book-page/borrow")
    public String borrowView(Model model, @RequestParam Integer id) throws NotEnoughBookException {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("availableCode", bookService.getRandomAvailableCode(book));
        return "book/borrow";
    }

    @PostMapping("/book-page/borrow")
    public String borrowBook(@ModelAttribute Book book, @RequestParam(name ="borrow_code") Integer borrowCode) {
        bookService.borrowBook(book, borrowCode);
        return "redirect:/book-page";
    }

    @GetMapping("/book-page/return")
    public String returnView(Model model, @RequestParam Integer id) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/return";
    }

    @PostMapping("/book-page/return")
    public String returnBook(@ModelAttribute Book book, @RequestParam(name ="return_code") Integer returnCode) throws CodeDoesNotExistException {
        bookService.returnBook(book, returnCode);
        return "redirect:/book-page";
    }

    @GetMapping("/book-page/delete/{id}")
    public String delete(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "redirect:/book-page";
    }

    @GetMapping("/book-page/search")
    public String search(@RequestParam("title") String title ,@RequestParam("author") String author ,@RequestParam("quantity") String quantity, @RequestParam(value = "page" , defaultValue = "0") int page , Model model)
    {

        Page<Book> bookPage = bookService.searchByTitleAndAuthorAndQuantity(title, author, quantity , PageRequest.of(page,5));
        model.addAttribute("title" , title);
        model.addAttribute("author" , author);
        model.addAttribute("quantity" , quantity);
        model.addAttribute("bookPage", bookPage);
        System.out.println(title + author + quantity);
        return "book/view_page";
    }


    @ExceptionHandler(NotEnoughBookException.class)
    public String notEnoughBookException() {
        return "exception/error_quantity_book";
    }

    @ExceptionHandler(CodeDoesNotExistException.class)
    public String codeDoesNotExistException() {
        return "exception/error_return_code";
    }
}
