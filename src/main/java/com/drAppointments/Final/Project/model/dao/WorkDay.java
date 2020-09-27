package com.drAppointments.Final.Project.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
public class WorkDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime start;
    private LocalTime finish;
    private DayOfWeek weekDay;

    public WorkDay(){}

    public WorkDay(int startHour, int finishHour, int weekDayNumber) {
        this.start = LocalTime.of(startHour, 0);
        this.finish = LocalTime.of(finishHour, 0);
        this.weekDay = DayOfWeek.of(weekDayNumber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public DayOfWeek getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(DayOfWeek weekDay) {
        this.weekDay = weekDay;
    }
}
