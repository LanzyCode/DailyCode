package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.bean.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import com.itheima.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public PageInfo findByPage(int currentPage, int pageSize) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        //2,获取代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        PageHelper.startPage(currentPage,pageSize);

        //3,调用方法进行数据库操作
        List<Student> list = studentMapper.findByPage();

        //4,将list数据封装到PageInfo对象中
        PageInfo info = new PageInfo(list);

        //5,释放资源
        sqlSession.close();
        return info;
    }

    @Override
    public void addStudent(Student stu) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession(false);
        //2,获取代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //3,调用方法进行数据库操作
        studentMapper.add(stu);
        //4,释放资源，提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateStudent(Student stu) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession(false);
        //2,获取代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //3,调用方法进行数据库操作
        studentMapper.update(stu);
        //4,释放资源，提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteStudent(String number) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession(false);
        //2,获取代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //3,调用方法进行数据库操作
        studentMapper.delete(number);
        //4,释放资源，提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
