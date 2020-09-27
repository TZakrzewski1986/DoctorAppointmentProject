package com.drAppointments.Final.Project.controller;

import com.drAppointments.Final.Project.model.dao.AdminDao;
import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //widok newpatient.html
    @GetMapping("/addpatient")
    public ModelAndView getAddNewPatientView() {
        return new ModelAndView("newpatient", "newPatient", new PatientDao());
    }

    //dodanie poprzez stronę nowego pacjenta
    @PostMapping("/addpatient")
    public String addNewPatient(@ModelAttribute PatientDao user) {
        System.out.println(user.toString());
        userService.addNewPatient(user);
        return "redirect:index";
    }

    //widok newdoctor.html
    @GetMapping("/adddoctor")
    public ModelAndView getAddNewDoctorView() {
        return new ModelAndView("newdoctor", "newDoctor", new DoctorDao());
    }

    //dodanie poprzez stronę nowego lekarza
    @PostMapping("/adddoctor")
    public String addNewDoctor(@ModelAttribute DoctorDao user) {
        System.out.println(user.toString());
        userService.addNewDoctor(user);
        return "redirect:index";
    }

    //widok newadmin.html
    @GetMapping("/addadmin")
    public ModelAndView getAddNewAdminView() {
        return new ModelAndView("newadmin", "newAdmin", new AdminDao());
    }

    //dodanie poprzez stronę nowego admina
    @PostMapping("/addadmin")
    public String addNewAdmin(@ModelAttribute AdminDao user) {
        System.out.println(user.toString());
        userService.addNewAdmin(user);
        return "redirect:index";
    }

}
