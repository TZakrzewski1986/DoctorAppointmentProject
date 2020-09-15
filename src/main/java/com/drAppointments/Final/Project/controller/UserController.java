package com.drAppointments.Final.Project.controller;

import com.drAppointments.Final.Project.model.dao.UserDao;
import com.drAppointments.Final.Project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public String addNewUser(@ModelAttribute UserDao user) {
        System.out.println(user.getName() + " " + user.getSurname());
        userService.addNewUser(user);
        return "redirect:index";
    }



}
