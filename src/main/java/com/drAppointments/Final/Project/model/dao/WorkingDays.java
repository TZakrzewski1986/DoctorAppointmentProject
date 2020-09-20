package com.drAppointments.Final.Project.model.dao;

public class WorkingDays {
    private WorkHours mon;
    private WorkHours tue;
    private WorkHours wed;
    private WorkHours thu;
    private WorkHours fri;
    private WorkHours sat;
    private WorkHours sun;

    public static final class WorkingDaysBuilder{
        private WorkHours mon;
        private WorkHours tue;
        private WorkHours wed;
        private WorkHours thu;
        private WorkHours fri;
        private WorkHours sat;
        private WorkHours sun;

        public static WorkingDaysBuilder WorkingDays() {
            return new WorkingDaysBuilder();
        }

        public WorkingDaysBuilder monHours(int startHours, int finishHours){
            this.mon = new WorkHours(startHours, finishHours);
            return this;
        }

        public WorkingDaysBuilder tueHours(int startHours, int finishHours){
            this.tue = new WorkHours(startHours, finishHours);
            return this;
        }

        public WorkingDaysBuilder wedHours(int startHours, int finishHours){
            this.wed = new WorkHours(startHours, finishHours);
            return this;
        }

        public WorkingDaysBuilder thuHours(int startHours, int finishHours){
            this.thu = new WorkHours(startHours, finishHours);
            return this;
        }

        public WorkingDaysBuilder friHours(int startHours, int finishHours){
            this.fri = new WorkHours(startHours, finishHours);
            return this;
        }

        public WorkingDaysBuilder satHours(int startHours, int finishHours){
            this.sat = new WorkHours(startHours, finishHours);
            return this;
        }

        public WorkingDaysBuilder sunHours(int startHours, int finishHours){
            this.sun = new WorkHours(startHours, finishHours);
            return this;
        }

        public WorkingDays build(){
            WorkingDays workingDays = new WorkingDays();
            workingDays.mon = this.mon;
            workingDays.tue = this.tue;
            workingDays.wed = this.wed;
            workingDays.thu = this.thu;
            workingDays.fri = this.fri;
            workingDays.sat = this.sat;
            workingDays.sun = this.sun;
            return workingDays;
        }
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
