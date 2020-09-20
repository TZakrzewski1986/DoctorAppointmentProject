package com.drAppointments.Final.Project.model.dao;

import java.time.LocalTime;

public class WorkHours {
    private LocalTime start;
    private LocalTime finish;

    private final int appointmentDuration = 30;

    public WorkHours(LocalTime start, LocalTime finish) {
        this.start = start;
        this.finish = finish;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public void setFinish(LocalTime finish) {
        this.finish = finish;
    }

    public int getAppointmentDuration() {
        return appointmentDuration;
    }
}
