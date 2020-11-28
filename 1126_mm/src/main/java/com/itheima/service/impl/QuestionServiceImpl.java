package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.CatalogMapper;
import com.itheima.dao.QuestionMapper;
import com.itheima.domain.Catalog;
import com.itheima.domain.Question;
import com.itheima.service.QuestionService;
import com.itheima.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class QuestionServiceImpl implements QuestionService {
    public PageInfo findByPage(int currentPage) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);

        PageHelper.startPage(currentPage,5);
        //调用查询方法
        List<Question> list = questionMapper.findAll();

        PageInfo pageInfo = new PageInfo(list);

        sqlSession.close();
        return pageInfo;
    }

    public void add(Question question) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);

        String id = UUID.randomUUID().toString();
        question.setId(id);
        //调用查询方法
        questionMapper.add(question);

        sqlSession.close();
    }

    public void update(Question question) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);

        //调用查询方法
        questionMapper.update(question);

        sqlSession.close();
    }

    public void delete(String id) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);

        questionMapper.delete(id);

        sqlSession.close();
    }
}
