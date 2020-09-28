package com.itheima.h1;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        double[] arr = {0.1, 0.2, 2.1, 3.2, 5.56, 7.21};
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < arr.length; i++) {
            BigDecimal bd = new BigDecimal(arr[i]);
            sum = bd.add(sum);
        }
        System.out.println(sum.divide(new BigDecimal(arr.length), 2, BigDecimal.ROUND_HALF_UP));
        System.out.println(sum.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP));
    }
}
