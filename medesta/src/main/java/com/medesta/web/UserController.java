package com.medesta.web;

import com.medesta.model.binding.LoginBindingModel;
import com.medesta.model.binding.RegisterBindingModel;
import com.medesta.model.service.UserServiceModel;
import com.medesta.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("registerBindingModel")) {
            model.addAttribute("registerBindingModel", new RegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute RegisterBindingModel registerBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !registerBindingModel.getPassword().equals(registerBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registerBindingModel", registerBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerBindingModel", bindingResult);

            return "redirect:register";
        }

        UserServiceModel userServiceModel = modelMapper
                .map(registerBindingModel, UserServiceModel.class);

        userService.registerUser(userServiceModel);

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("loginBindingModel")) {
            model.addAttribute("loginBindingModel", new LoginBindingModel());
            model.addAttribute("NotFound", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute LoginBindingModel loginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginBindingModel", bindingResult);

            return "redirect:login";
        }
        UserServiceModel user = userService.findUserByUsernameAndPassword(loginBindingModel.getUsername(), loginBindingModel.getPassword());

        if (user == null) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel);
            redirectAttributes.addFlashAttribute("NotFound", true);

            return "redirect:login";
        }
        httpSession.setAttribute("user", user);

        return "home";
    }
}
