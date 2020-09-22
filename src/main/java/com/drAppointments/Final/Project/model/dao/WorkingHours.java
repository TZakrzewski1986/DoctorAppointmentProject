package com.drAppointments.Final.Project.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkingHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int monStart;
    private int tueStart;
    private int wedStart;
    private int thuStart;
    private int friStart;
    private int satStart;
    private int sunStart;
    private int monFinish;
    private int tueFinish;
    private int wedFinish;
    private int thuFinish;
    private int friFinish;
    private int satFinish;
    private int sunFinish;

    public static final class WorkingHoursBuilder {
        private int monStart;
        private int tueStart;
        private int wedStart;
        private int thuStart;
        private int friStart;
        private int satStart;
        private int sunStart;
        private int monFinish;
        private int tueFinish;
        private int wedFinish;
        private int thuFinish;
        private int friFinish;
        private int satFinish;
        private int sunFinish;

        public static WorkingHoursBuilder WorkingHours() {
            return new WorkingHoursBuilder();
        }

        public WorkingHoursBuilder monStart(int monStart){
            this.monStart = monStart;
            return this;
        }
        public WorkingHoursBuilder monFinish(int monFinish){
            this.monFinish = monFinish;
            return this;
        }
        public WorkingHoursBuilder tueStart(int tueStart){
            this.tueStart = tueStart;
            return this;
        }
        public WorkingHoursBuilder tueFinish(int tueFinish){
            this.tueFinish = tueFinish;
            return this;
        }
        public WorkingHoursBuilder wedStart(int wedStart){
            this.wedStart = wedStart;
            return this;
        }
        public WorkingHoursBuilder wedFinish(int wedFinish){
            this.wedFinish = wedFinish;
            return this;
        }
        public WorkingHoursBuilder thuStart(int thuStart){
            this.thuStart = thuStart;
            return this;
        }
        public WorkingHoursBuilder thuFinish(int thuFinish){
            this.thuFinish = thuFinish;
            return this;
        }
        public WorkingHoursBuilder friStart(int friStart){
            this.friStart = friStart;
            return this;
        }
        public WorkingHoursBuilder friFinish(int friFinish){
            this.friFinish = friFinish;
            return this;
        }
        public WorkingHoursBuilder satStart(int satStart){
            this.satStart = satStart;
            return this;
        }
        public WorkingHoursBuilder satFinish(int satFinish){
            this.satFinish = satFinish;
            return this;
        }
        public WorkingHoursBuilder sunStart(int sunStart){
            this.sunStart = sunStart;
            return this;
        }
        public WorkingHoursBuilder sunFinish(int sunFinish){
            this.sunFinish = sunFinish;
            return this;
        }
        public WorkingHours build(){
            WorkingHours workingHours = new WorkingHours();
            workingHours.monStart = this.monStart;
            workingHours.monFinish = this.monFinish;
            workingHours.tueStart = this.tueStart;
            workingHours.tueFinish = this.tueFinish;
            workingHours.wedStart = this.wedStart;
            workingHours.wedFinish = this.wedFinish;
            workingHours.thuStart = this.thuStart;
            workingHours.thuFinish = this.thuFinish;
            workingHours.friStart = this.friStart;
            workingHours.friFinish = this.friFinish;
            workingHours.satStart = this.satStart;
            workingHours.satFinish = this.satFinish;
            workingHours.sunStart = this.sunStart;
            workingHours.sunFinish = this.sunFinish;
            return workingHours;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMonStart() {
        return monStart;
    }

    public void setMonStart(int monStart) {
        this.monStart = monStart;
    }

    public int getTueStart() {
        return tueStart;
    }

    public void setTueStart(int tueStart) {
        this.tueStart = tueStart;
    }

    public int getWedStart() {
        return wedStart;
    }

    public void setWedStart(int wedStart) {
        this.wedStart = wedStart;
    }

    public int getThuStart() {
        return thuStart;
    }

    public void setThuStart(int thuStart) {
        this.thuStart = thuStart;
    }

    public int getFriStart() {
        return friStart;
    }

    public void setFriStart(int friStart) {
        this.friStart = friStart;
    }

    public int getSatStart() {
        return satStart;
    }

    public void setSatStart(int satStart) {
        this.satStart = satStart;
    }

    public int getSunStart() {
        return sunStart;
    }

    public void setSunStart(int sunStart) {
        this.sunStart = sunStart;
    }

    public int getMonFinish() {
        return monFinish;
    }

    public void setMonFinish(int monFinish) {
        this.monFinish = monFinish;
    }

    public int getTueFinish() {
        return tueFinish;
    }

    public void setTueFinish(int tueFinish) {
        this.tueFinish = tueFinish;
    }

    public int getWedFinish() {
        return wedFinish;
    }

    public void setWedFinish(int wedFinish) {
        this.wedFinish = wedFinish;
    }

    public int getThuFinish() {
        return thuFinish;
    }

    public void setThuFinish(int thuFinish) {
        this.thuFinish = thuFinish;
    }

    public int getFriFinish() {
        return friFinish;
    }

    public void setFriFinish(int friFinish) {
        this.friFinish = friFinish;
    }

    public int getSatFinish() {
        return satFinish;
    }

    public void setSatFinish(int satFinish) {
        this.satFinish = satFinish;
    }

    public int getSunFinish() {
        return sunFinish;
    }

    public void setSunFinish(int sunFinish) {
        this.sunFinish = sunFinish;
    }
}
