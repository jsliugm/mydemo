package com.cal;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class TimeInterval {
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;

    public TimeInterval(int startHour, int startMinute, int endHour, int endMinute) {
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    // Getters and setters

    public static List<TimeInterval> generateTimeIntervals() {
        List<TimeInterval> intervals = new ArrayList<>();
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute += 10) {
                TimeInterval interval = new TimeInterval(hour, minute, hour, minute + 10);
                intervals.add(interval);
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        List<TimeInterval> intervals = TimeInterval.generateTimeIntervals();
        for (TimeInterval interval : intervals) {
            System.out.println(interval.getStartHour() + ":" + interval.getStartMinute() +
                    " - " + interval.getEndHour() + ":" + interval.getEndMinute());
        }
    }
}
