package com.emarsys.assignment;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        IssueService issueService = new IssueService();
        System.out.println(issueService.calculateDueDate(Calendar.getInstance(), 8));
    }

}
