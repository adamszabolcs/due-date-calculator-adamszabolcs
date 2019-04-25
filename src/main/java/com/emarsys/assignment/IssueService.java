package com.emarsys.assignment;

import com.emarsys.assignment.exception.BadTurnAroundTime;

import java.util.Calendar;

public class IssueService {

    public Calendar calculateDueDate(Calendar submitDate, int turnAroundTime) {
        if (turnAroundTime <= 0) {
            throw new BadTurnAroundTime("Bad turnaround time!");
        }
        Calendar calendar = Calendar.getInstance();
        int turnAroundHour = submitDate.get(Calendar.HOUR_OF_DAY) + turnAroundTime;
        calendar.set(Calendar.HOUR_OF_DAY, turnAroundHour);
        return calendar;
    }

}
