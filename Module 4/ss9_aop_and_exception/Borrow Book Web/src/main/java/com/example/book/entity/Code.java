package com.example.book.entity;
import javax.persistence.*;

@Entity
@Table(name = "code")
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private Integer code ;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book ;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Code() {
    }

    public Code(int id, Integer code, Book book, Status status) {
        this.id = id;
        this.code = code;
        this.book = book;
        this.status = status;
    }

    public Code(Integer code, Book book, Status status) {
        this.code = code;
        this.book = book;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
