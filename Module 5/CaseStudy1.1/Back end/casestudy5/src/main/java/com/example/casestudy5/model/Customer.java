package com.example.casestudy5.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer")
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;


    @NotBlank(message ="Name can not blank")
    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_birthday")
    private String birthDay;

    @NotNull(message ="Id card can not null")
    @Column(name = "customer_id_card")
    private Integer idCard;

    @NotBlank(message ="Phone can not blank")
    @Column(name = "customer_phone")
    private String phone;

    @NotBlank(message ="Email can not blank")
    @Column(name = "customer_email")
    private String email;

    @NotBlank(message ="Address can not blank")
    @Column(name = "customer_address")
    private String address;

    @NotNull(message = "Customer Type can not null")
    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(Integer id, String name, String birthDay, Integer idCard, String phone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if (customer.getName().length() < 10){
            errors.rejectValue("name","NameLength","HiHi");
        }
    }
}
