package product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_management.model.Product;
import product_management.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    public List<Product> list = new ArrayList<>();
    @Autowired
    public ProductService productService;
    @GetMapping("/list")
    public ModelAndView getList(Model model) {
        ModelAndView modelAndView = new ModelAndView("list");
        list = productService.findAll();
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        Product product = new Product();
        ModelAndView modelAndView = new ModelAndView("createForm","product",product);

        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);

        redirectAttributes.addFlashAttribute("mess","Created new product successfully!");
        return "redirect:/product/list";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable String id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView;
        if(product != null) {
            modelAndView = new ModelAndView("editForm","product",product);
        }else {
            modelAndView = new ModelAndView("list","mess","No product found!");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(),product);

        redirectAttributes.addFlashAttribute("mess","Edited product successfully!");
        return "redirect:/product/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        productService.remove(product);

        redirectAttributes.addFlashAttribute("mess","Deleted product successfully!");
        return "redirect:/product/list";

    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable String id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("viewDetail","product",product);

        return  modelAndView;
    }

    @GetMapping("/search")
    public String search(@RequestParam String name,RedirectAttributes redirectAttributes,Model model) {
        Product product = productService.findByName(name);
        if(product!=null) {
            model.addAttribute("product",product);
             return "viewDetail";
        }else {
            redirectAttributes.addFlashAttribute("mess","No product found!");
           return "redirect:/product/list";
        }

    }

}
