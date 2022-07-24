package com.example.book.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^[A-Za-z\\s]{5,50}$", message= "Title malformed")
    private String title;


    @Pattern(regexp = "^[A-Za-z\\s]{5,50}$", message= "Author malformed")
    private String author;

    @NotNull(message = "Quantity must not be Null")
    private Integer quantity;

    @Column(columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Must be a date in the Past or in the Present")
    private LocalDate year;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Code> code ;

    public Book() {
    }

    public Book(Integer id, @Pattern(regexp = "^[A-Za-z\\s]{5,50}$", message = "Title malformed") String title, @Pattern(regexp = "^[A-Za-z\\s]{5,50}$", message = "Author malformed") String author, @NotNull(message = "Quantity must not be Null") Integer quantity, @PastOrPresent(message = "Must be a date in the Past or in the Present") LocalDate year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.year = year;
    }

    public Book(int id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }

//    public Date getYear() {
//        return year;
//    }
//
//    public void setYear(Date year) {
//        this.year = year;
//    }


    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public List<Code> getCode() {
        return code;
    }

    public void setCode(List<Code> code) {
        this.code = code;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
          Book book = (Book) target;
          LocalDate today = LocalDate.now();
          LocalDate dateOfBirth = book.getYear();
          if (dateOfBirth == null)
          {
              errors.rejectValue("year","YearNotNull");
          }
//          else
//          {
//              LocalDate LocalDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//              if (Period.between(LocalDate,today).getYears() < 18)
//              {
//                  errors.rejectValue("year","18Year");
//              }
//          }
//          if (!book.title.matches("^[A-Za-z\\s]{5,50}$")){
//              errors.rejectValue("title","title.invalidFormat");
//          }
    }
}
