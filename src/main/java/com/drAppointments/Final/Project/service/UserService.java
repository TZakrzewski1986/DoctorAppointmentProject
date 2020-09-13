package com.drAppointments.Final.Project.service;

//import com.sda.mvc.model.dao.UserDao;
//import com.sda.mvc.model.dto.UserDto;
//import com.sda.mvc.model.dto.UserSecDto;

import com.drAppointments.Final.Project.model.dao.UserDao;
import com.drAppointments.Final.Project.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String getNameAndSurnameLoggedUser() {

        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<UserDao> userByLogin = userRepository.getUserByLogin(login);

        return userByLogin
                .map(userDao -> userDao.getName() + " " + userDao.getSurname())
                .orElse(login);
    }
}
