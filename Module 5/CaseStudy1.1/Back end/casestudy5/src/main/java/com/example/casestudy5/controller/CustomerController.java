package com.example.casestudy5.controller;

import com.example.casestudy5.model.Customer;
import com.example.casestudy5.model.CustomerType;
import com.example.casestudy5.service.Impl.CustomerService;
import com.example.casestudy5.service.Impl.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getListCustomer()
    {
      try{
          List<Customer> customerList = customerService.findAll();
          if (customerList.size() ==0)
          {
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
          return new ResponseEntity<>(customerList,HttpStatus.OK);
      }
      catch (Exception e){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer)
    {
        try{
            customerService.createCustomer(customer);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id) {
        try {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Customer> getCustomerById (@PathVariable("id") Integer id) {
        try{
            Customer customer = customerService.findById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer)
    {
        try{
            customerService.updateCustomer(customer);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/type")
    public ResponseEntity<List<CustomerType>> getListCustomerType()
    {
        try{
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            if (customerTypeList.size() ==0)
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customerTypeList,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Customer>> getAllCustomersPaginate(@RequestParam("page") Integer page,
                                                                   @RequestParam("size") Integer size) {
        Page<Customer> customers = customerService.getAllPaginate(page, size);
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Customer>> getAllCustomerByName(@RequestParam("page") Integer page,
                                                                    @RequestParam("size") Integer size , @RequestParam("name") String name) {
        Page<Customer> customers = customerService.getByName(name , page, size);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<Customer>> getAllCustomerByType(@RequestParam("page") Integer page,
                                                                    @RequestParam("size") Integer size , @RequestParam("id") Integer id) {
        Page<Customer> customers = customerService.getByCustomerType(id , page, size);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/filter-customerType-name")
    public ResponseEntity<Page<Customer>> findByCustomerTypeAndName(@RequestParam("page") Integer page,
                                                              @RequestParam("size") Integer size , @RequestParam("name") String name, @RequestParam("id") Integer id) {
        Page<Customer> customers = customerService.findByNameAndType(id, name, page, size);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
