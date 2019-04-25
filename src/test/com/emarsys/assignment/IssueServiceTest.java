package com.emarsys.assignment;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IssueServiceTest {

    static IssueService issueService;
    static Calendar calendar;


    @BeforeAll
    public static void init() {
        issueService = new IssueService();
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, 3);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
    }


    @Test
    public void smoke() {
        assertTrue(true);
    }

    @Test()
    public void checkForAddingHours() {
        Calendar testCalendar = issueService.calculateDueDate(calendar, 2);
        assertTrue(testCalendar.get(Calendar.HOUR_OF_DAY)-calendar.get(Calendar.HOUR_OF_DAY) == 2,
                "Adding hours works");
    }
}