package com.drAppointments.Final.Project.service;

import org.junit.jupiter.api.Test;

import java.text.DateFormatSymbols;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CalendarAdapterTest {

    CalendarAdapter calendar = new CalendarAdapter();

    String[] allMonths = new DateFormatSymbols().getShortMonths();

    @Test
    void listYears() {
        List<Integer> years = Arrays.asList(calendar.getCurrentYear(), calendar.getCurrentYear()+1, calendar.getCurrentYear()+2);
        List<Integer> badYears = Arrays.asList(calendar.getCurrentYear(), calendar.getCurrentYear()+1);

        assertEquals(years, calendar.listYears());
        assertNotEquals(badYears, calendar.listYears());
    }

    @Test
    void listMonthsShortLeftThisYear() {
        List<String> monthsShortLeft = calendar.listMonths(calendar.getCurrentYear());
        List<String> expectedMonthsShortLeft = Arrays.asList(allMonths).subList(calendar.getCurrentMonth()-1, 12);
        assertEquals(expectedMonthsShortLeft, monthsShortLeft);
    }

    @Test
    void listAllMonthsShort(){
        List<String> monthsShortAll = calendar.listMonths(calendar.getCurrentYear()+1);
        List<String> expectedMonthsShortAll = Arrays.asList(allMonths).subList(0, 12);
        assertEquals(expectedMonthsShortAll, monthsShortAll);
    }

    @Test
    void listDaysLeftCurrentMonth() {
        List<Integer> expectedDaysLeft = Arrays.asList(26,27,28,29,30);
        List<Integer> daysLeft = calendar.listDays(calendar.getCurrentMonth(), calendar.getCurrentYear());
        assertEquals(expectedDaysLeft, daysLeft);
    }

    @Test
    void listDaysDecember() {
        List<Integer> expectedDaysDecember = new ArrayList<>();
        for (int i  = 1; i <= 31; i++){
            expectedDaysDecember.add(i);
        }
        List<Integer> daysInDecember = calendar.listDays(12, calendar.getCurrentYear()+1);
        assertEquals(expectedDaysDecember, daysInDecember);
    }

    @Test
    void listDaysFebruary() {
        List<Integer> expectedDaysFebruaryNormal = new ArrayList<>();
        for (int i  = 1; i <= 28; i++){
            expectedDaysFebruaryNormal.add(i);
        }
        List<Integer> expectedDaysFebruaryLeap = new ArrayList<>(expectedDaysFebruaryNormal);
        expectedDaysFebruaryLeap.add(29);

        List<Integer> daysInFebruaryNormal = calendar.listDays(2, 2021);
        assertEquals(expectedDaysFebruaryNormal, daysInFebruaryNormal);

        List<Integer> daysInFebruaryLeap = calendar.listDays(2, 2020);
        assertEquals(expectedDaysFebruaryLeap, daysInFebruaryLeap);
    }

    @Test
    void listTimeFromCurrent() {
        List<LocalTime> expectedTimeListFromNow = createTimeList(calendar.getCurrentTime().getHour(), calendar.getCurrentTime().getMinute());
        List<LocalTime> actual = calendar.listTime(calendar.getCurrentDay(), calendar.getCurrentMonth(), calendar.getCurrentYear());
        assertEquals(expectedTimeListFromNow, actual);
    }

    @Test
    void listTimeAll(){
        List<LocalTime> expectedTimeListFromNow = createTimeList(6, 0);
        List<LocalTime> actual = calendar.listTime(calendar.getCurrentDay()+1, calendar.getCurrentMonth(), calendar.getCurrentYear());
        assertEquals(expectedTimeListFromNow, actual);

    }

    private List<LocalTime> createTimeList(int startHour, int startMinutes){
        int loopLimit;
        if (startMinutes == 0){
            loopLimit = (22-startHour)*2-1;
        } else {
            loopLimit = (21-startHour)*2;
        }
        if (startMinutes > 0 && startMinutes < 30){
            startMinutes = 30;
        } else if (startMinutes >= 30 && startMinutes < 60){
            startMinutes = 0;
            startHour += 1;
        }
        LocalTime start = LocalTime.of(startHour,startMinutes);
        List<LocalTime> timeList = new ArrayList<>();
        timeList.add(start);
        LocalTime nextApp = start;
        for (int i = 0; i < loopLimit; i++){
            nextApp = nextApp.plusMinutes(30);
            if (nextApp.equals(LocalTime.of(22, 0)))
                break;
            timeList.add(nextApp);
        }
        return timeList;
    }
}