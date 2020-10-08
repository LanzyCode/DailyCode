package com.itheima.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo4 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("1008_IO/b.txt")) {
            fos.write(789);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
