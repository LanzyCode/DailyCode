package com.lanzycode.h3;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1, 332, 43, 25, 3324, 34, 335, 4, 45, 2, 43, 52, 54};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
