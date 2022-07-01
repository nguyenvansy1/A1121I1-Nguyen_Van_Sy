package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.IMedicalDeclarationService;
import com.codegym.service.MedicalDeclarationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medical")
public class MedicalDeclarationController {
    private IMedicalDeclarationService medicalDeclarationService = new MedicalDeclarationService();

    @GetMapping("")
    public String showAll(Model model) {
        List<MedicalDeclaration> medicalDeclarationList = medicalDeclarationService.showAll();
        model.addAttribute("medicalDeclarations", medicalDeclarationList);
        return "/list";
    }

    @GetMapping("/{id}/view")
    public String viewDetail(@PathVariable int id, Model model) {
        model.addAttribute("medicalDeclaration", medicalDeclarationService.findById(id));
        return "/view";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute MedicalDeclaration medicalDeclaration, Model model) {
        String msg;
        if (medicalDeclarationService.create(medicalDeclaration)) {
            msg = "Create successfully";
        } else {
            msg = "Create failure";
        }
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        model.addAttribute("msg", msg);
        return "/create";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("medicalDeclaration", medicalDeclarationService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute MedicalDeclaration medicalDeclaration, Model model) {
        String msg;
        if (medicalDeclarationService.update(medicalDeclaration)) {
            msg = "Update successfully";
        } else {
            msg = "Update failure";
        }
        model.addAttribute(medicalDeclarationService.findById(medicalDeclaration.getId()));
        model.addAttribute("msg", msg);
        return "/edit";
    }
}
