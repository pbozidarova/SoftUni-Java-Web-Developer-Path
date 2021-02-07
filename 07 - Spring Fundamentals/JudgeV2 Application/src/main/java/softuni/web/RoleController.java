package com.softuni.web;

import com.softuni.model.enitity.RoleNameEnum;
import com.softuni.service.UserService;
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

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addRole(Model model){
        model.addAttribute("names", userService.findAllUsernames());

        return "role-add";
    }

    @PostMapping("/add")
    public String addConfirm(@RequestParam String username,
                             @RequestParam String role){

        userService.changeRole( username,
                                RoleNameEnum.valueOf(role.toUpperCase()));

        return "redirect:/";
    }
}
