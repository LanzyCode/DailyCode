package com.lanzycode.charstream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CharStreamDemo7 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("1009_IOChar/number.txt")));
        bw.write("3,5,4,7,9,10,1");
        bw.flush();
        BufferedReader br = new BufferedReader(new FileReader(new File("1009_IOChar/number.txt")));
        String line = br.readLine();
        String[] split=line.split(",");
        int[] arr=new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
