package com.cal;

import org.junit.Test;

import java.util.Calendar;

public class CalendarDemo {
    @Test
    public void test(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,-30);
        System.out.println(cal.getTime());
    }
}
