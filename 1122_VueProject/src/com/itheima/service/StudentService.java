package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.bean.Student;

public interface StudentService {

    /**
     * 分页查询
     * @param currentPage  ： 当前页码
     * @param pageSize  ： 每页显示的条目数
     * @return
     */
    PageInfo findByPage(int currentPage,int pageSize);

    /**
     * 添加学生
     * @param stu  ： 封装学生数据的对象
     */
    void addStudent(Student stu);

    /**
     * 修改学生
     * @param stu  ： 封装学生数据的对象
     */
    void updateStudent(Student stu);

    /**
     * 删除学生信息
     * @param number  ： 学号
     */
    void deleteStudent(String number);
}
