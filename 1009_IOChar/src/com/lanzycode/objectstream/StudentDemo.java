package com.lanzycode.objectstream;

import com.lanzycode.domain.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StudentWrite();
        StudentReader();
    }

    private static void StudentReader() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("1009_IOChar/student.txt"));
        System.out.println(ois.readObject());
        ois.close();
    }

    private static void StudentWrite() throws IOException {
        ObjectOutputStream ots=new ObjectOutputStream(new FileOutputStream("1009_IOChar/student.txt"));
        ArrayList<Student> list=new ArrayList<>(List.of(new Student("张三",23),new Student("李四",24),new Student("王五",25)));
        ots.writeObject(list);
        ots.close();
    }
}
