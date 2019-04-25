package com.emarsys.assignment;

import com.emarsys.assignment.exception.BadSubmitDate;
import com.emarsys.assignment.exception.BadTurnAroundTime;

import java.util.Calendar;

public class IssueService {

    public static final int WORK_DAYS = 5;
    public static final int WORK_START_TIME = 9;
    public static final int WORK_END_TIME = 17;
    public static final int WORKHOURS = 8;

    public Calendar calculateDueDate(Calendar submitDate, int turnAroundTime) {
        int time = submitDate.get(Calendar.HOUR_OF_DAY);
        int day = submitDate.get(Calendar.DAY_OF_WEEK);

        if (turnAroundTime <= 0) {
            throw new BadTurnAroundTime("Bad turnaround time!");
        } else if (day > WORK_DAYS || (time < WORK_START_TIME || time > WORK_END_TIME)) {
            throw new BadSubmitDate("Can't submit issue on the submitted date!");
        }

        Calendar calendar = Calendar.getInstance();
        int submitHour = time + turnAroundTime;
        int dayChange = 0;

        if (submitHour > WORK_END_TIME) {
            submitHour = WORKHOURS + (submitHour % WORKHOURS);
            dayChange++;
        }
        if (turnAroundTime > WORKHOURS) {
            dayChange += turnAroundTime / WORKHOURS;
        }

        calendar.set(Calendar.DAY_OF_WEEK, day + dayChange);
        calendar.set(Calendar.HOUR_OF_DAY, submitHour);
        return calendar;
    }

}
