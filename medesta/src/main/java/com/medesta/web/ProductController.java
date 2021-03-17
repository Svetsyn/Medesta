package com.medesta.web;

import com.medesta.model.binding.ProductBindingModel;
import com.medesta.model.enums.ProductCategory;
import com.medesta.model.service.ProductServiceModel;
import com.medesta.service.ProductService;
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
@RequestMapping("/products")
public class ProductController {

    private final ModelMapper modelMapper;
    private final ProductService productService;

    public ProductController(ModelMapper modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("productBindingModel")) {
            model.addAttribute("productBindingModel", new ProductBindingModel());
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductBindingModel productBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productBindingModel", productBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productBindingModel", bindingResult);

            System.out.println();
            return "redirect:add";
        }

        ProductServiceModel productServiceModel = modelMapper
                .map(productBindingModel, ProductServiceModel.class);

        productService.addProduct(productServiceModel);

        return "redirect:/";
    }
}
