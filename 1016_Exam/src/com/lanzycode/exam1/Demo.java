package com.lanzycode.exam1;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Demo{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Class<Student> studentClass = Student.class;
        for (int i = 1; i < 4; i++) {
            System.out.println("请输入第" + i + "个学生的姓名:");
            String name = sc.next();
            System.out.println("请输入第" + i + "个学生的语文成绩:");
            int chineseScore = sc.nextInt();
            System.out.println("请输入第" + i + "个学生的数学成绩:");
            int mathScore = sc.nextInt();
            System.out.println("请输入第" + i + "个学生的英语成绩:");
            int englishScore = sc.nextInt();
            Constructor<Student> constructor = studentClass.getDeclaredConstructor(String.class, Integer.class, Integer.class, Integer.class);
            constructor.setAccessible(true);
            Student student = constructor.newInstance(name, chineseScore, mathScore, englishScore);
            studentList.add(student);
        }
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o2.getSumScore() - o1.getSumScore();
                if (result == 0)
                    result = o2.getChineseScore() - o1.getChineseScore();
                if (result == 0)
                    result = o2.getMathScore() - o1.getMathScore();
                return result;
            }
        });

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("1016_Exam/student.txt")));
        for (Student student : studentList) {
            bw.write(student.getString());
            bw.newLine();
            bw.flush();
        }

        BufferedReader br=new BufferedReader(new FileReader(new File("1016_Exam/student.txt")));
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
        bw.close();

    }
}

