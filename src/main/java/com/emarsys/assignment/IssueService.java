package com.emarsys.assignment;

import com.emarsys.assignment.exception.BadSubmitDate;
import com.emarsys.assignment.exception.BadTurnAroundTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IssueService {

    public static final int WORK_DAYS = 5;
    public static final int WORK_START_TIME = 9;
    public static final int WORK_END_TIME = 17;
    public static final int WORKHOURS = 8;

    public String calculateDueDate(Calendar submitDate, int turnAroundTime) {
        submitDate.setFirstDayOfWeek(Calendar.MONDAY);
        int time = submitDate.get(Calendar.HOUR_OF_DAY);
        int day = submitDate.get(Calendar.DAY_OF_WEEK);

        if (turnAroundTime <= 0) {
            throw new BadTurnAroundTime("Bad turnaround time!");
        } else if ((day == Calendar.SATURDAY || day == Calendar.SUNDAY)
                || (time < WORK_START_TIME || time > WORK_END_TIME)) {
            throw new BadSubmitDate("Can't submit issue on the submitted date!");
        }

        Calendar calendar = Calendar.getInstance();
        int submitHour = time + turnAroundTime;

        if (submitHour > WORK_END_TIME) {
            submitHour = WORKHOURS + (submitHour % WORKHOURS);
            day++;
        }
        if (turnAroundTime > WORKHOURS) {
            day += turnAroundTime / WORKHOURS;
        }
        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
            day = (day % WORK_DAYS);
        }

        calendar.set(Calendar.DAY_OF_WEEK, day);
        calendar.set(Calendar.HOUR_OF_DAY, submitHour);

        SimpleDateFormat format = new SimpleDateFormat("hh:mma E");
        return format.format(calendar.getTime());
    }

}
