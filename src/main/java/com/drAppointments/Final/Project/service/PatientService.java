package com.drAppointments.Final.Project.service;

import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.model.dao.SpecializationDao;
import com.drAppointments.Final.Project.repository.AppointmentRepository;
import com.drAppointments.Final.Project.repository.DoctorRepository;
import com.drAppointments.Final.Project.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    public PatientService(PatientRepository patientRepository, DoctorRepository doctorRepository,
                          ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addNewPatient(PatientDao user) {
        PatientDao patientDao = modelMapper.map(user, PatientDao.class);
        patientDao.setPassword(passwordEncoder.encode(user.getPassword()));
        patientRepository.save(patientDao);
    }

    public String getNameAndSurnameLoggedUser() {

        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<PatientDao> userByLogin = patientRepository.getPatientByLogin(login);

        return userByLogin
                .map(userDao -> userDao.getName() + " " + userDao.getSurname())
                .orElse(login);
    }

    public List<DoctorDao> getDoctorByMedicalSpecialization(SpecializationDao medicalSpecialization){
        return doctorRepository.getDoctorByMedicalSpecialization(medicalSpecialization);
    }

    public Optional<DoctorDao> getDoctorByNameAndSurname(String name, String surname){
        return doctorRepository.getDoctorByNameAndSurname(name, surname);
    }


}
