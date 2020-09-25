package com.drAppointments.Final.Project.repository;

import com.drAppointments.Final.Project.model.dao.SpecializationDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<SpecializationDao, Long> {

    List<SpecializationDao> findAll();

}
