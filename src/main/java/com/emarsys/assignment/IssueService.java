package com.emarsys.assignment;

import com.emarsys.assignment.exception.BadSubmitDate;
import com.emarsys.assignment.exception.BadTurnAroundTime;

import java.util.Calendar;

public class IssueService {

    public Calendar calculateDueDate(Calendar submitDate, int turnAroundTime) {
        if (turnAroundTime <= 0) {
            throw new BadTurnAroundTime("Bad turnaround time!");
        } else if (submitDate.get(Calendar.DAY_OF_WEEK) > 5 ||
                (submitDate.get(Calendar.HOUR_OF_DAY) < 9 || submitDate.get(Calendar.HOUR_OF_DAY) > 17)) {
            throw new BadSubmitDate("Can't submit issue on the submitted date!");
        }
        Calendar calendar = Calendar.getInstance();
        int turnAroundHour = submitDate.get(Calendar.HOUR_OF_DAY) + turnAroundTime;
        calendar.set(Calendar.HOUR_OF_DAY, turnAroundHour);
        return calendar;
    }

}
