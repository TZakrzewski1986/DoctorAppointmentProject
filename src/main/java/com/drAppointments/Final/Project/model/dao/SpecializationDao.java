package com.drAppointments.Final.Project.model.dao;

import javax.persistence.*;

@Entity
public class SpecializationDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String specialization;

}
