package com.drAppointments.Final.Project.model.dao;

public class WorkingDays {
    private WorkHours mon;
    private WorkHours tue;
    private WorkHours wed;
    private WorkHours thu;
    private WorkHours fri;
    private WorkHours sat;
    private WorkHours sun;

    public WorkingDays(WorkHours mon, WorkHours tue, WorkHours wed, WorkHours thu, WorkHours fri, WorkHours sat, WorkHours sun) {
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
    }

    public WorkHours getMon() {
        return mon;
    }

    public void setMon(WorkHours mon) {
        this.mon = mon;
    }

    public WorkHours getTue() {
        return tue;
    }

    public void setTue(WorkHours tue) {
        this.tue = tue;
    }

    public WorkHours getWed() {
        return wed;
    }

    public void setWed(WorkHours wed) {
        this.wed = wed;
    }

    public WorkHours getThu() {
        return thu;
    }

    public void setThu(WorkHours thu) {
        this.thu = thu;
    }

    public WorkHours getFri() {
        return fri;
    }

    public void setFri(WorkHours fri) {
        this.fri = fri;
    }

    public WorkHours getSat() {
        return sat;
    }

    public void setSat(WorkHours sat) {
        this.sat = sat;
    }

    public WorkHours getSun() {
        return sun;
    }

    public void setSun(WorkHours sun) {
        this.sun = sun;
    }
}
