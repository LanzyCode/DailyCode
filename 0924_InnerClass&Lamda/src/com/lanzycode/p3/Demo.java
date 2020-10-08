package com.lanzycode.p3;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {16, 23, 37, 48, 56, 58, 60};
        System.out.println("请输入要查找的数字");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int i = getIndexInArray(arr, number);
        if (i == -1) {
            System.out.println("您找的数不在这个数组中");
        } else {
            System.out.println("您要找个数字在数组的第" + (i + 1) + "个位置");
        }
    }

    public static int getIndexInArray(int[] arr, int number) {
        if (number < arr[0] || number > arr.length - 1) {
            return -1;
        }
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (arr[mid] > number) {
                max = mid - 1;
            } else if (arr[mid] < number) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
