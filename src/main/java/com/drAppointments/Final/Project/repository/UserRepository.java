package com.drAppointments.Final.Project.repository;

import com.drAppointments.Final.Project.model.dao.UserDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDao, Long> {

    Optional<UserDao> getUserByLogin(@Param("login") String login);

}
