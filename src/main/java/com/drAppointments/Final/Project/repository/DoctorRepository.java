package com.drAppointments.Final.Project.repository;

import com.drAppointments.Final.Project.model.dao.DoctorDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorDao, Long> {

    Optional<DoctorDao> getDoctorByLogin(@Param("login") String login);
}
