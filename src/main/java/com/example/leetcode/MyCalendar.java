package com.example.leetcode;

import java.util.ArrayList;

public class MyCalendar {
    private ArrayList<int[]> booking;

    public MyCalendar() {
        booking = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (booking.size() == 0) {
            booking.add(new int[] {start, end});
            return true;
        }
        for (int i = 0; i < booking.size(); i++) {
            int[] date = booking.get(i);

            if (end > date[0] && start < date[1])
                return false;
        }
        booking.add(new int[] {start, end});
        return true;
    }
}
