package com.drAppointments.Final.Project.service;

//import com.sda.mvc.model.dao.UserDao;
//import com.sda.mvc.model.dto.UserDto;
//import com.sda.mvc.model.dto.UserSecDto;

import com.drAppointments.Final.Project.model.dao.AdminDao;
import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.model.dao.UserDao;
import com.drAppointments.Final.Project.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public String getNameAndSurnameLoggedUser() {

        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<UserDao> userByLogin = userRepository.getUserByLogin(login);

        return userByLogin
                .map(userDao -> userDao.getName() + " " + userDao.getSurname())
                .orElse(login);
    }

    public void addNewPatient(PatientDao user) {
        PatientDao patientDao = modelMapper.map(user, PatientDao.class);
        patientDao.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(patientDao);
    }

    public void addNewDoctor(DoctorDao user) {
        DoctorDao doctorDao = modelMapper.map(user, DoctorDao.class);
        doctorDao.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(doctorDao);
    }

    public void addNewAdmin(AdminDao user) {
        AdminDao adminDao = modelMapper.map(user, AdminDao.class);
        adminDao.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(adminDao);
    }
}
