package com.emarsys.assignment;

import com.emarsys.assignment.exception.BadSubmitDate;
import com.emarsys.assignment.exception.BadTurnAroundTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class IssueServiceTest {

    IssueService issueService;
    Calendar calendar;


    @BeforeEach
    public void init() {
        issueService = new IssueService();
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
    }


    @Test
    public void smoke() {
        assertTrue(true);
    }

    @Test()
    public void testForAddingHours() {
        String returnValue = issueService.calculateDueDate(calendar, 2);
        assertEquals(1, Integer.parseInt(returnValue.substring(0,2)));
    }

    @Test
    public void throwExceptionIfTurnAroundTimeIsZero() {
        assertThrows(BadTurnAroundTime.class, () -> issueService.calculateDueDate(calendar, 0));
    }

    @Test
    public void throwExceptionIfTurnAroundTimeIsNegative() {
        assertThrows(BadTurnAroundTime.class, () -> issueService.calculateDueDate(calendar, -3));
    }

    @Test
    public void throwExceptionIfSubmitDateDayIsWeekEnd() {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        assertThrows(BadSubmitDate.class, () -> issueService.calculateDueDate(calendar, 2));
    }

    @Test
    public void throwExceptionIfSubmitDateTimeIsOnWorkingHours() {
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        assertThrows(BadSubmitDate.class,() -> issueService.calculateDueDate(calendar, 2));
    }

    @Test
    public void changeDayIfTurnAroundTimeIsBiggerThanWorkHour() {
        String returnValue = issueService.calculateDueDate(calendar, 8);
        assertEquals("Thu", returnValue.substring(8));
    }

    @Test
    public void checkIfHourIsSetProperlyWhenTimeIsBiggerThanWorkHour() {
        String returnValue = issueService.calculateDueDate(calendar, 8);
        assertEquals(11, Integer.parseInt(returnValue.substring(0, 2)));
    }

    @Test
    public void checkIfDayIsSetProperlyWhenWeekendComes() {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        calendar.set(Calendar.HOUR_OF_DAY,16);
        String returnValue = issueService.calculateDueDate(calendar, 2);
        assertEquals("Mon", returnValue.substring(8));
    }
}
