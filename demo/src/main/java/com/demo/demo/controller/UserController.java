package com.demo.demo.controller;

import com.demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("queryAllUser")
    public String queryAllUser(Model model){
        model.addAttribute("users", userService.findAll());
        return "users";
    }
}
