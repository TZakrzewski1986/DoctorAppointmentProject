package com.drAppointments.Final.Project.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
public class SpecializationDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String specialization;

    @OneToMany(fetch = FetchType.LAZY)
    private List<DoctorDao> doctors;

}
