package com.medesta.web;

import com.medesta.model.entity.Role;
import com.medesta.model.entity.User;
import com.medesta.model.enums.RoleName;
import com.medesta.model.service.RoleServiceModel;
import com.medesta.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping("roles")
public class RoleController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public RoleController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("names", userService.findAllUsername());
        return "role-add";
    }

    @PostMapping("/add")
    public String addConfirm(@RequestParam String username,
                             @RequestParam String role){

        userService.changeRole(username,RoleName.valueOf(role.toUpperCase()));

        return "redirect:add";
    }


}