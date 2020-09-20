package com.drAppointments.Final.Project.model.dao;

import java.time.LocalTime;

public class WorkHours {
    private LocalTime start;
    private LocalTime finish;

    private final int appointmentDuration = 30;

    public WorkHours(int startHours, int startMinutes, int finishHours, int finishMinutes) {
        start = LocalTime.of(startHours, startMinutes);
        finish = LocalTime.of(finishHours, finishMinutes);
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(int startHours, int startMinutes) {
        start = LocalTime.of(startHours, startMinutes);
    }

    public LocalTime getFinish() {
        return finish;
    }

    public void setFinish(int finishHours, int finishMinutes) {
        finish = LocalTime.of(finishHours, finishMinutes);
    }

    public int getAppointmentDuration() {
        return appointmentDuration;
    }
}
