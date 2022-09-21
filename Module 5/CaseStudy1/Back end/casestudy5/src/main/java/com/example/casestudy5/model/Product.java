package com.example.casestudy5.model;

import javax.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String xuatXu;

    private String donVi;

    private Integer giaTien;
    public Product() {
    }

    public Product(Integer id, String name, String xuatXu, String donVi) {
        this.id = id;
        this.name = name;
        this.xuatXu = xuatXu;
        this.donVi = donVi;
    }

    public Product(Integer id, String name, String xuatXu, String donVi, Integer giaTien) {
        this.id = id;
        this.name = name;
        this.xuatXu = xuatXu;
        this.donVi = donVi;
        this.giaTien = giaTien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Integer getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Integer giaTien) {
        this.giaTien = giaTien;
    }
}
