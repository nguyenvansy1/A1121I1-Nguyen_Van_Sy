package customer_management.controller;

import customer_management.entity.Customer;
import customer_management.entity.Province;
import customer_management.service.CustomerService;
import customer_management.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Page<Province> provinces(Pageable pageable) {
        return provinceService.findAll(pageable);
    }

    @GetMapping("/customers")
    public ModelAndView listCustomers(@PageableDefault(value = 3) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Customer> list;
        if(!search.isPresent()) {
           list  = customerService.findAll( pageable);
        }else {
            list = customerService.findAllByFirstNameContaining(search.get(),pageable);
        }

        ModelAndView modelAndView = new ModelAndView("list","list",list);

        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        Customer customer = new Customer();
        ModelAndView modelAndView = new ModelAndView("create","customer",customer);

        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Create new customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editForm(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id).orElse(null);
        ModelAndView modelAndView = new ModelAndView("edit","customer",customer);

        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Edit customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Delete customer successfully!");
        return "redirect:/customers";
    }

}
