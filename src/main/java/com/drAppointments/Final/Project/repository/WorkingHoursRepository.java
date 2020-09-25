package com.drAppointments.Final.Project.repository;

import com.drAppointments.Final.Project.model.dao.WorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingHoursRepository extends JpaRepository<Long, WorkingHours> {
    
}
