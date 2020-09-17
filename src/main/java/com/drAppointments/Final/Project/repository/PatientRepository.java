package com.drAppointments.Final.Project.repository;

import com.drAppointments.Final.Project.model.dao.PatientDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientDao, Long> {

    Optional<PatientDao> getPatientByLogin(@Param("login") String login);
}
