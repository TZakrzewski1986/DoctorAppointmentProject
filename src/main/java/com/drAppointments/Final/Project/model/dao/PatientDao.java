package com.drAppointments.Final.Project.model.dao;

import com.drAppointments.Final.Project.model.dao.UserDao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientDao extends UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
