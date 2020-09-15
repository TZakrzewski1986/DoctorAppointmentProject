package com.drAppointments.Final.Project.controller;

import com.drAppointments.Final.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // w przypadku RestController zwraca obiekt, a Controller zwraca widok (stronę)
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public ModelAndView getIndexView() {

        return new ModelAndView("index", "user", userService.getNameAndSurnameLoggedUser());

    }

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }
}

