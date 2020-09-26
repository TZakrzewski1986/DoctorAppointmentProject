package com.drAppointments.Final.Project.service;

import com.drAppointments.Final.Project.model.dao.UserSec;
import com.drAppointments.Final.Project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserSec userSec = patientRepository.getPatientByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
        return new UserDetailsService(userSec);
    }
}
