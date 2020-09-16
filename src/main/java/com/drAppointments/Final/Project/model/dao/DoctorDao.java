package com.drAppointments.Final.Project.model.dao;

import com.drAppointments.Final.Project.model.dao.UserDao;

import javax.persistence.*;

@Entity
public class DoctorDao extends UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String medicalSpecialization;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicalSpecialization() {
        return medicalSpecialization;
    }

    public void setMedicalSpecialization(String medicalSpecialization) {
        this.medicalSpecialization = medicalSpecialization;
    }
}


