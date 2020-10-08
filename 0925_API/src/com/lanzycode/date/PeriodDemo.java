package com.lanzycode.date;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDemo {
    public static void main(String[] args) {
        Period bt = Period.between(LocalDate.of(1949, 10, 1), LocalDate.now());
        System.out.println(bt.getYears() + "  " + bt.getMonths() + "  " + bt.getDays());
        System.out.println(bt.toTotalMonths());
        /*使用ChronoUnit类提供的枚举*/
        long res = ChronoUnit.MONTHS.between(LocalDate.of(1949, 10, 1), LocalDate.now());
        System.out.println(res);
    }
}
