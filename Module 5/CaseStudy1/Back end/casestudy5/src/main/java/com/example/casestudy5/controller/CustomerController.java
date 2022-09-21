package com.example.casestudy5.controller;

import com.example.casestudy5.model.Item;
import com.example.casestudy5.model.Product;
import com.example.casestudy5.service.Impl.CustomerService;
import com.example.casestudy5.service.Impl.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

//    @GetMapping("/list")
//    public ResponseEntity<List<Item>> getListCustomer()
//    {
//      try{
//          List<Item> itemList = customerService.findAll();
//          if (itemList.size() ==0)
//          {
//              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//          }
//          return new ResponseEntity<>(itemList,HttpStatus.OK);
//      }
//      catch (Exception e){
//          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//      }
//    }
//
    @PostMapping("/add")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody Item item)
    {
        try{
            customerService.createCustomer(item);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
//
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
//
//    @GetMapping("/find/{id}")
//    public ResponseEntity<Item> getCustomerById (@PathVariable("id") Integer id) {
//        try{
//            Item item = customerService.findById(id);
//            return new ResponseEntity<>(item, HttpStatus.OK);
//        }catch (Exception e)
//        {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PatchMapping("/update")
//    public ResponseEntity<?> updateCustomer(@RequestBody Item item)
//    {
//        try{
//            customerService.updateCustomer(item);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }catch (Exception e)
//        {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
    @GetMapping("/type")
    public ResponseEntity<List<Product>> getListCustomerType()
    {
        try{
            List<Product> productList = customerTypeService.findAll();
            if (productList.size() ==0)
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productList,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Item>> getAllCustomersPaginate(@RequestParam("page") Integer page,
                                                              @RequestParam("size") Integer size) {
        Page<Item> customers = customerService.getAllPaginate(page, size);
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Item>> getAllCustomerByName(@RequestParam("page") Integer page,
                                                           @RequestParam("size") Integer size , @RequestParam("name") String name) {
        Page<Item> customers = customerService.getByName(name , page, size);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
//
//    @GetMapping("/filter")
//    public ResponseEntity<Page<Item>> getAllCustomerByType(@RequestParam("page") Integer page,
//                                                           @RequestParam("size") Integer size , @RequestParam("id") Integer id) {
//        Page<Item> customers = customerService.getByCustomerType(id , page, size);
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }
//
//    @GetMapping("/filter-customerType-name")
//    public ResponseEntity<Page<Item>> findByCustomerTypeAndName(@RequestParam("page") Integer page,
//                                                                @RequestParam("size") Integer size , @RequestParam("name") String name, @RequestParam("id") Integer id) {
//        Page<Item> customers = customerService.findByNameAndType(id, name, page, size);
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }
//
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

//    @PostMapping("/add")
//    @ResponseBody
//    public ResponseEntity<Object> saveCustomer(@Valid @RequestBody Customer customer, BindingResult result)
//    {
//        if (result.hasErrors()) {
//            List<String> errors = result.getAllErrors().stream()
//                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                    .collect(Collectors.toList());
//            return new ResponseEntity<>(errors, HttpStatus.OK);
//        } else {
//            if (customer.getName().length() <10) {
//                return new ResponseEntity<>(
//                        Collections.singletonList("Name invalid!"),
//                        HttpStatus.BAD_REQUEST);
//            } else {
//                customerService.createCustomer(customer);
//                return new ResponseEntity<>(HttpStatus.CREATED);
//            }
//        }
//    }
}
