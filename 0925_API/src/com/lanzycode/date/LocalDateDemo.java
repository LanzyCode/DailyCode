package com.lanzycode.date;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate old = LocalDate.of(1970, 1, 1);
        LocalDate localDate = old.withYear(2020).withMonth(6).withDayOfMonth(15);
        System.out.println("初始化时间为：" + old);
        System.out.println("修改后的时间为：" + localDate);
        old.with(ChronoField.YEAR, 2021);
    }
}
