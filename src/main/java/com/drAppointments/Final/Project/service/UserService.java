package com.drAppointments.Final.Project.service;

//import com.sda.mvc.model.dao.UserDao;
//import com.sda.mvc.model.dto.UserDto;
//import com.sda.mvc.model.dto.UserSecDto;

import com.drAppointments.Final.Project.model.dao.AdminDao;
import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.model.dao.WorkDay;
import com.drAppointments.Final.Project.repository.AdminRepository;
import com.drAppointments.Final.Project.repository.DoctorRepository;
import com.drAppointments.Final.Project.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private AdminRepository adminRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    public UserService(AdminRepository adminRepository,
                       DoctorRepository doctorRepository, PatientRepository patientRepository,
                       ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public String getNameAndSurnameLoggedAdmin() {

        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<AdminDao> adminByLogin = adminRepository.getAdminByLogin(login);

        return adminByLogin
                .map(adminDao -> adminDao.getName() + " " + adminDao.getSurname())
                .orElse(login);
    }

    public void addNewDoctor(DoctorDao user) {
        DoctorDao doctorDao = modelMapper.map(user, DoctorDao.class);
        // adding default working hours for created doctor before saving to db
        doctorDao.setWorkingHours(defaultWorkDays());
        doctorDao.setPassword(passwordEncoder.encode(user.getPassword()));
        doctorRepository.save(doctorDao);
    }

    //filling working hours list with dummy hours and correct week days enums
    private List<WorkDay> defaultWorkDays(){
        List<WorkDay> workDays = new ArrayList<>();
        for (int i = 1; i <= 7; i++){
            workDays.add(new WorkDay(0, 0, i));
        }
        return workDays;
    }

    public void addNewAdmin(AdminDao user) {
        AdminDao adminDao = modelMapper.map(user, AdminDao.class);
        adminDao.setPassword(passwordEncoder.encode(user.getPassword()));
        adminRepository.save(adminDao);
    }

//    //do wywoływania metody cyklicznie
//    @Scheduled(initialDelay = 10000L, fixedDelay = 10000L)
//    public void test(){
//        System.out.println("testing scheduling");
//    }
}
