package com.drAppointments.Final.Project.repository;


import com.drAppointments.Final.Project.model.dao.AdminDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminDao, Long> {

    Optional<AdminDao> getAdminByLogin(@Param("login") String login);





}
