package com.drAppointments.Final.Project.controller;

import com.drAppointments.Final.Project.model.dao.AdminDao;
import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.service.PatientService;
import com.drAppointments.Final.Project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService userService;

    private PatientService patientService;

    public UserController(UserService userService, PatientService patientService) {
        this.userService = userService;
        this.patientService = patientService;
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
        patientService.addNewPatient(user);
        return "redirect:patient";
    }

//    // widok zalogowanego pacjenta
//    @GetMapping("/patient")
//    public ModelAndView getLoggedPatientView() {
//        return new ModelAndView("patient", "patient",
//                patientService.getNameAndSurnameLoggedUser());
//    }

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
