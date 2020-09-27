package com.drAppointments.Final.Project.service;

import org.springframework.stereotype.Component;

import java.text.DateFormatSymbols;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CalendarAdapter {
    private int currentYear;
    private int currentMonth;
    private int currentDay;
    private int dayOfWeek;
    private LocalTime currentTime;

    public CalendarAdapter() {
        this.currentYear = LocalDate.now().getYear();
        this.currentMonth = LocalDate.now().getMonthValue();
        this.currentDay = LocalDate.now().getDayOfMonth();
        this.dayOfWeek = LocalDate.now().getDayOfWeek().getValue();
        this.currentTime = LocalTime.now();
    }

    public List<Integer> listYears() {
        return Arrays.asList(currentYear, currentYear+1, currentYear+2);
    }

    public List<String> listMonths(int year) {
        String[] allMonths = new DateFormatSymbols().getShortMonths();
        if (year == currentYear) {
            return new ArrayList<>(Arrays.asList(allMonths).subList(currentMonth - 1, 12));
        } else {
            return new ArrayList<>(Arrays.asList(allMonths).subList(0, 12));
        }
    }

    public List<Integer> listDays(int monthNumber, int year) {
        if (year == currentYear && monthNumber == currentMonth){
            return IntStream.rangeClosed(currentDay, daysInMonth(monthNumber, year)).boxed().collect(Collectors.toList());
        } else {
            return IntStream.rangeClosed(1, daysInMonth(monthNumber, year)).boxed().collect(Collectors.toList());
        }
    }

    private int daysInMonth(int monthNumber, int year){
        List<Integer> longMonths = Arrays.asList(1,3,5,7,8,10,12);
        List<Integer> shortMonths = Arrays.asList(4, 6, 9, 11);
        if (longMonths.contains(monthNumber)){
            return 31;
        }
        if (shortMonths.contains(monthNumber)){
            return 30;
        }
        if (monthNumber == 2 && year % 400 != 0 && year % 4 != 0){
            return 28;
        } else {
            return 29;
        }

    }

    public List<LocalTime> listTime(int day, int monthNumber, int year) {
        if (day == currentDay && monthNumber == currentMonth && year == currentYear
                && currentTime.compareTo(LocalTime.of(21, 30)) < 0) {
            int nextClosestIndex = 0;
            List<LocalTime> timeList = createTimeList();
            for (LocalTime time : timeList) {
                Duration diff = Duration.between(currentTime, time);
                if (diff.getSeconds() > 0) {
                    nextClosestIndex = timeList.indexOf(time);
                    break;
                }
            }
            return timeList.subList(nextClosestIndex, timeList.size());

        } else {
            return createTimeList();
        }
    }

    private List<LocalTime> createTimeList(){
        LocalTime start = LocalTime.of(6,0);
        List<LocalTime> timeList = new ArrayList<>();
        timeList.add(start);
        LocalTime nextApp = start;
        for (int i = 0; i < 31; i++){
            nextApp = nextApp.plusMinutes(30);
            timeList.add(nextApp);
        }
        return timeList;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }
}
