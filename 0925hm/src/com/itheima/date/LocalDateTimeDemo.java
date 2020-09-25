package com.itheima.date;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.of(2019, 7, 19, 14, 38, 34);
        LocalDateTime resultTime = now.minusYears(3).minusMonths(5).minusDays(7).minusHours(4);
        Period period = Period.of(3, 10, 10);
        LocalDateTime res = now.plus(period);
        LocalDateTime res1 = now.plus(3, ChronoUnit.DECADES);
        System.out.println(res1);
        System.out.println(res);
        System.out.println(resultTime);
        LocalDateTime resultTime1 = now.minusMonths(5);
        System.out.println(resultTime1);
    }
}
