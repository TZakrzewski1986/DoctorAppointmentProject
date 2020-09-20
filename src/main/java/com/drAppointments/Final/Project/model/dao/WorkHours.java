package com.drAppointments.Final.Project.model.dao;

import java.time.LocalTime;

public class WorkHours {
    private LocalTime start;
    private LocalTime finish;

    private final int APPOINTMENT_DURATION = 30;
    private final int CLINIC_OPENING = 6;
    private final int CLINIC_CLOSING = 22;

    public WorkHours(int startHours, int finishHours) {
        start = LocalTime.of(validateStartHours(startHours), 0);
        finish = LocalTime.of(validateFinishHours(finishHours), 0);
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(int startHours) {
        start = LocalTime.of(startHours, 0);
    }

    public LocalTime getFinish() {
        return finish;
    }

    public void setFinish(int finishHours) {
        finish = LocalTime.of(finishHours, 0);
    }

    public int getAppointmentDuration() {
        return APPOINTMENT_DURATION;
    }

    private int validateStartHours(int startHours){
        if (startHours < CLINIC_OPENING)
            startHours = CLINIC_OPENING;
        if (startHours >= CLINIC_CLOSING)
            startHours = CLINIC_CLOSING-1;
        return startHours;
    }

    private int validateFinishHours(int finishHours){
        if (finishHours > CLINIC_CLOSING)
            finishHours = CLINIC_CLOSING;
        if (finishHours < CLINIC_OPENING)
            finishHours = CLINIC_OPENING+1;
        return finishHours;
    }
}
