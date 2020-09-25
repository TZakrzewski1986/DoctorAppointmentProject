package com.drAppointments.Final.Project.service;

import org.springframework.stereotype.Component;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
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
        String[] allMonths = new DateFormatSymbols().getMonths();
        if (year == currentYear) {
            return new ArrayList<>(Arrays.asList(allMonths).subList(currentMonth - 1, 11));
        } else {
            return new ArrayList<>(Arrays.asList(allMonths));
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
        List<Integer> shortMonths = Arrays.asList(2, 4, 6, 9, 11);
        if (longMonths.contains(monthNumber)){
            return 31;
        }
        if (shortMonths.contains(monthNumber)){
            return 30;
        }
        if (year % 400 != 0 && year % 4 != 0){
            return 28;
        } else {
            return 29;
        }

    }


}
