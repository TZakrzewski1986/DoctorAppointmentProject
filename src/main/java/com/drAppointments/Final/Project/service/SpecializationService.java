package com.drAppointments.Final.Project.service;

import com.drAppointments.Final.Project.model.dao.SpecializationDao;
import com.drAppointments.Final.Project.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    @Autowired
    SpecializationRepository specializationRepository;

    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public List<SpecializationDao> findAll(){
        return specializationRepository.findAll();
    }
}
