package customer_management.controller;

import customer_management.entity.Customer;
import customer_management.entity.Province;
import customer_management.service.CustomerService;
import customer_management.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/provinces")
    public ModelAndView listProvinces(Pageable pageable) {
        Page<Province> list = provinceService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("province/list","list",list);

        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showCreateForm() {
        Province province = new Province();
        ModelAndView modelAndView = new ModelAndView("province/create","province",province);

        return modelAndView;
    }

    @PostMapping("/create-province")
    public String saveProvince(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("mess","Create new province successfully!");
        return "redirect:/province/provinces";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editForm(@PathVariable("id") Long id) {
        Province province = provinceService.findById(id).orElse(null);
        ModelAndView modelAndView = new ModelAndView("province/edit","province",province);

        return modelAndView;
    }

    @PostMapping("/edit")
    public String editProvince(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("mess","Edit province successfully!");
        return "redirect:/province/provinces";
    }

    @GetMapping("/delete/{id}")
    public String deleteProvince(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        provinceService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Delete province successfully!");
        return "redirect:/province/provinces";
    }

    @GetMapping("/view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id) {
        Optional<Province> province = provinceService.findById(id);

        if(!province.isPresent()) {
            return new ModelAndView("/error.404");
        }
        Iterable<Customer> list = customerService.findAllByProvince(province.get());
        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("province",province.get());
        modelAndView.addObject("list",list);

        return modelAndView;
    }
}
