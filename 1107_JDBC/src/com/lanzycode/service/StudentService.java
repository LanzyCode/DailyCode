package com.lanzycode.service;

import com.lanzycode.domain.Student;

import java.util.ArrayList;

public interface StudentService {
    //查询所有学生信息
    ArrayList<Student> findAll();

    //条件查询，根据id获取学生信息
    Student findById(Integer id);

    //新增学生信息
    int insert(Student stu);

    //修改学生信息
    int update(Student stu);

    //删除学生信息
    int delete(Integer id);
}
