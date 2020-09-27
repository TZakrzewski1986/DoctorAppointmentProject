package com.drAppointments.Final.Project.controller;

import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.service.PatientService;
import com.drAppointments.Final.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    PatientService patientService;


    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public ModelAndView patientHome() {
        return new ModelAndView("patient", "patient",
                patientService.getNameAndSurnameLoggedUser());
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

}
