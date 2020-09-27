package com.drAppointments.Final.Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentProvider {

    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private CalendarAdapter calendarAdapter;


}
