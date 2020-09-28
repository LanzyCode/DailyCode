package com.itheima.p4;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 7, 1, 9, 8};
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                flag = false;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));

    }


}
