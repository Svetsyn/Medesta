package com.medesta.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @GetMapping("/add")
    public String add(Model model){
        if (!model.containsAttribute("")){
            model.addAttribute("",new)
        }
        return "customer-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ){


    }
}
