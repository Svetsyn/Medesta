package com.medesta.web;

import com.medesta.model.binding.CustomerRegisterBindingModel;
import com.medesta.model.service.CustomerServiceModel;
import com.medesta.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final ModelMapper modelMapper;
    private final CustomerService customerService;

    public CustomerController(ModelMapper modelMapper, CustomerService customerService) {
        this.modelMapper = modelMapper;
        this.customerService = customerService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("customerRegisterBindingModel")) {
            model.addAttribute("customerRegisterBindingModel", new CustomerRegisterBindingModel());
        }
        return "customer-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid CustomerRegisterBindingModel customerRegisterBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("customerRegisterBindingModel", customerRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.customerRegisterBindingModel", bindingResult);

            return "redirect:add";
        }

        CustomerServiceModel customerServiceModel=modelMapper
                .map(customerRegisterBindingModel,CustomerServiceModel.class);

        customerService.addCustomer(customerServiceModel);

        return "redirect:/";

    }
}
