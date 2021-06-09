package com.validation;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

@DayCheck(message = "{year}年{month}的天数区间为[]")
@Data
public class Date {
    @Range(max = 9999,min=0,message = "年份的区间为[{min},{max}]")
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
