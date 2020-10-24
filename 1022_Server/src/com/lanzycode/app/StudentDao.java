package com.lanzycode.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;

public class StudentDao {
    private static final Logger LOGGER=LoggerFactory.getLogger(StudentDao.class);
    private static ArrayList<Student> list=new ArrayList<>();
    private static Integer Id=0;
    public static void addStudent(String studentInfo) {
        //序列化流读取学生集合数据
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("student.txt")));
            try {
                list= (ArrayList<Student>) ois.readObject();
            } catch (ClassNotFoundException e) {
                LOGGER.error("[服务器端]反序列化出现错误");
            }
        } catch (IOException e) {
            LOGGER.error("[服务器端]反序列化出现错误");
        }
        //添加读取后的数据
        String[] studentInfos=studentInfo.split(",");
        list.add(new Student(Id++,studentInfos[0],studentInfos[1],studentInfos[2]));
        //反序列化流写入数据
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("student.txt")));
        } catch (IOException e) {
            LOGGER.error("[服务器端]写入失败，序列化出现错误");
        }
    }
}
