package com.example.casestudy5.model;

import com.example.casestudy5.util.customValidation.BirthDayCustom;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Pattern(regexp = "^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$" , message = "Birth Day malformed yyyy-MM-dd or mismatched date")
    @PastOrPresent(message = "Birth Day can not Future ")
    @BirthDayCustom(message = "Birth Day can not null ")
    private LocalDate birthDay;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDay;

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

    public Customer(Integer id, String name, LocalDate birthDay, Integer idCard, String phone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Customer(Integer id, @NotBlank(message = "Name can not blank") String name, @PastOrPresent(message = "Birth Day can not Future ") LocalDate birthDay, LocalDate endDay, @NotNull(message = "Id card can not null") Integer idCard, @NotBlank(message = "Phone can not blank") String phone, @NotBlank(message = "Email can not blank") String email, @NotBlank(message = "Address can not blank") String address, @NotNull(message = "Customer Type can not null") CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.endDay = endDay;
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
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


    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
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

    public static void main(String[] args) {
        String m = "2001-12-";
        Boolean str1 = m.matches("^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(|-|)(?:0?[13578]|1[02])\\1(?:31))|(?:(|-|)' + '(?:0?[13-9]|1[0-2])\\2(?:29|30)))$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(|-|)0?2\\3(?:29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(|-|)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:0?[1-9]|1\\d|2[0-8])$");
        System.out.println(str1);
    }
}
