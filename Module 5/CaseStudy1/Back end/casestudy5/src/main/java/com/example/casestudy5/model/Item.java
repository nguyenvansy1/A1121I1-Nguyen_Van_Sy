package com.example.casestudy5.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private Integer quantity;

    private LocalDate nhap;

    private LocalDate xuat;

    private LocalDate han;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Item() {
    }

    public Item(Integer id, String code, Integer quantity, LocalDate nhap, LocalDate xuat, LocalDate han, Product product) {
        this.id = id;
        this.code = code;
        this.quantity = quantity;
        this.nhap = nhap;
        this.xuat = xuat;
        this.han = han;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getNhap() {
        return nhap;
    }

    public void setNhap(LocalDate nhap) {
        this.nhap = nhap;
    }

    public LocalDate getXuat() {
        return xuat;
    }

    public void setXuat(LocalDate xuat) {
        this.xuat = xuat;
    }

    public LocalDate getHan() {
        return han;
    }

    public void setHan(LocalDate han) {
        this.han = han;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
