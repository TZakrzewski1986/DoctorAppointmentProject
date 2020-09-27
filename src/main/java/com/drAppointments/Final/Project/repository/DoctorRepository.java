package com.drAppointments.Final.Project.repository;

import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.model.dao.SpecializationDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorDao, Long> {

    Optional<DoctorDao> getDoctorByLogin(@Param("login") String login);

    List<DoctorDao> getDoctorByMedicalSpecialization(SpecializationDao medSpec);

    Optional<DoctorDao> getDoctorByNameAndSurname(String name, String surname);
}
