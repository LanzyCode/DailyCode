package com.lanzycode.p2;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        String str = "91.4 27.23 46.4 38.7 50.2";
        String[] strings = str.split(" ");
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < strings.length; i++) {
            BigDecimal bd = new BigDecimal(strings[i]);
            sum = bd.add(sum);

        }
        System.out.println("和为" + sum);
        System.out.println("平均值为" + (sum.divide(BigDecimal.valueOf(strings.length), 2, BigDecimal.ROUND_HALF_UP)));
        System.out.println(str);
    }
}
