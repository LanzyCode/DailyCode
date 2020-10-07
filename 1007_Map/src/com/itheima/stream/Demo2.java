package com.itheima.stream;

/*求N个数的和*/
public class Demo2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int sum1 = getSum(arr);
        System.out.println(sum1);
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
