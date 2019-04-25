package com.emarsys.assignment;

import com.emarsys.assignment.exception.BadSubmitDate;
import com.emarsys.assignment.exception.BadTurnAroundTime;

import java.util.Calendar;

public class IssueService {

    public Calendar calculateDueDate(Calendar submitDate, int turnAroundTime) {
        int time = submitDate.get(Calendar.HOUR_OF_DAY);
        int day = submitDate.get(Calendar.DAY_OF_WEEK);
        if (turnAroundTime <= 0) {
            throw new BadTurnAroundTime("Bad turnaround time!");
        } else if (day > 5 || (time < 9 || time > 17)) {
            throw new BadSubmitDate("Can't submit issue on the submitted date!");
        }
        Calendar calendar = Calendar.getInstance();
        int turnAroundHour = time + turnAroundTime;
        calendar.set(Calendar.HOUR_OF_DAY, turnAroundHour);
        return calendar;
    }

}
