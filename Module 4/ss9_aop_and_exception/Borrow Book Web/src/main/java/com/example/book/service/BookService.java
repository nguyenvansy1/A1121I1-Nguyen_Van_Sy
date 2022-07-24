package com.example.book.service;


import com.example.book.entity.Book;
import com.example.book.entity.Code;
import com.example.book.entity.Status;
import com.example.book.exception.CodeDoesNotExistException;
import com.example.book.exception.NotEnoughBookException;
import com.example.book.repository.IBookRepository;
import com.example.book.repository.ICodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private IBookRepository bookRepository;

    @Autowired ICodeService codeService;

    @Autowired
    private ICodeRepository codeRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
      bookRepository.save(book);
      for (int i = 0; i < book.getQuantity(); i++) {
           int n = (int)(Math.random() * (9000) + 1000);
           Code code = new Code(n,new Book(book.getId()),new Status(1));
           codeService.save(code);
      }
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrowBook(Book book, Integer usedCode) {
        List<Code> codeList = codeService.findAllCodeByBookId(book.getId());
        for (Code code : codeList) {
            if (code.getCode().equals(usedCode)) {
                code.setStatus(new Status(2));
                break;
            }
        }
        if (book.getQuantity()>0)
        {
         book.setQuantity(book.getQuantity()-1);
        }
        bookRepository.save(book);
    }

    @Override
    public Code getRandomAvailableCode(Book book) throws NotEnoughBookException {
        List<Code> codeList = codeService.findAvailableCodeByBookId(book.getId());
        if (codeList.size() == 0){
            throw new NotEnoughBookException();
        }
        int n = (int)(Math.random() * book.getQuantity());
        return codeList.get(n);
    }

    @Override
    public void returnBook(Book book, Integer returnCode) throws CodeDoesNotExistException {
        List<Code> codeList = codeService.findUsedCodeByBookId(book.getId());
        boolean check = false ;
        for (Code code : codeList)
        {
            if (code.getCode().equals(returnCode))
            {
                code.setStatus(new Status(1));
                codeRepository.save(code);
                check = true;
                break;
            }
        }
        if (!check){
            throw new CodeDoesNotExistException();
        }
        book.setQuantity(book.getQuantity()+1);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> fillAll(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> searchByTitleAndAuthorAndQuantity(String title, String author, String quantity , Pageable pageable) {
       return bookRepository.searchByTitleAndAuthorAndQuantity("%"+title+"%","%"+author+"%", "%"+quantity+"%" , pageable);
    }

}
