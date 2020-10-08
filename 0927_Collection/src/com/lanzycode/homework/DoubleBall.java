package com.lanzycode.homework;

import java.util.ArrayList;
import java.util.Random;

public class DoubleBall {

    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= 33; i++) {
            numList.add(i);
        }
        Random r = new Random();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        ArrayList<Object> newList = new ArrayList<Object>();
        int temp = 0;
        for (int i = 0; i < 7; i++) {
            temp = r.nextInt(numList.size());
            if (!tempList.contains(temp)) {
                tempList.add(temp);
                newList.add(numList.get(temp));
            } else {
                i--;
            }
        }
        System.out.println("中奖号码为：");
        System.out.println(newList);
    }

}
