package com.medesta.web;

import com.medesta.model.binding.LoginBindingModel;
import com.medesta.model.binding.RegisterBindingModel;
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
@RequestMapping("/users")
public class UserController {


    @GetMapping("/register")
    public String register(Model model) {
        if(!model.containsAttribute("registerBindingModel")){
            model.addAttribute("registerBindingModel",new RegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid RegisterBindingModel registerBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerBindingModel",registerBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerBindingModel",bindingResult);

            return "redirect:register";
        }

        //Todo save in the DB
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model){
        if (model.containsAttribute("loginBindingModel")){
            model.addAttribute("loginBindingModel",new LoginBindingModel());
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid LoginBindingModel loginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginBindingModel",loginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginBindingModel",bindingResult);

            return "redirect:login";
        }

        return "/home";
    }
}
