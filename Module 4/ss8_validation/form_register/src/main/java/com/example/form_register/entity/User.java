package com.example.form_register.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Size(min = 5  , max = 45 , message = "Size 5-45")
    private String firstName;

    @Size(min = 5  , max = 45 ,message = "Size 5-45")
    private  String lastName;

    @Pattern(regexp = "^\\+84-[0-9]{9}$" , message = "Phone error")
    private String phone;


    private Integer age;

    @NotBlank(message = "Not blank")
    private String email;

    public User() {
    }

    public User(Integer id, @Size(min = 5, max = 45, message = "Size 5-45") String firstName, @Size(min = 5, max = 45, message = "Size 5-45") String lastName, @Pattern(regexp = "^\\+84-[0-9]{9}$", message = "Phone error") String phone, Integer age, @NotBlank(message = "Not blank") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
         User user = (User) target;

         if (user.age == null)
         {
             errors.rejectValue("age","NotNullAge");
         }
         else  if(user.age < 18)
         {
             errors.rejectValue("age","Age18");
         }
    }
}
