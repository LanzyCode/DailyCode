package com.lanzycode.p5;

public class Demo {
    public static void main(String[] args) {
        int result = getResult(13);
        System.out.println(result);
    }

    private static int getResult(int i) {
        if (i == 1) {
            return 1;
        }
        return i * getResult(i - 1);
    }
}
