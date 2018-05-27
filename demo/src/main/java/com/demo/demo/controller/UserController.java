package com.demo.demo.controller;

import com.demo.demo.domain.User;
import com.demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("queryAllUser")
    public String queryAllUser(Model model){
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("maps")
    public String maps(Model model){
        List<User> users = userService.findAll();
        HashMap<String, List<String>> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("a",users.stream().map(User::getName).collect(Collectors.toList()));
        objectObjectHashMap.put("b",users.stream().map(User::getName).collect(Collectors.toList()));
        model.addAttribute("maps",objectObjectHashMap);
        return "maps";
    }

    @RequestMapping("input")
    public String input(Model model){
        String input = "<input type=\"checkbox\" value=\"1\" name=\"id\">nana\n";
        model.addAttribute("input",input);
        return "maps";
    }
}
