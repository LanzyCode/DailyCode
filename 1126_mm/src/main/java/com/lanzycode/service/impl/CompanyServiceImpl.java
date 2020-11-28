package com.lanzycode.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanzycode.dao.CompanyMapper;
import com.lanzycode.domain.Company;
import com.lanzycode.service.CompanyService;
import com.lanzycode.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class CompanyServiceImpl implements CompanyService {

    public List<Company> findAll() {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2,获取代理对象
        CompanyMapper companyMapper = sqlSession.getMapper(CompanyMapper.class);

        //3,调用方法进行数据库操作
        List<Company> list = companyMapper.findAll();

        //5,释放资源
        sqlSession.close();
        return list;
    }

    public String findCompanyIdByCompanyName(String catalogName) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2,获取代理对象
        CompanyMapper companyMapper = sqlSession.getMapper(CompanyMapper.class);

        //3,调用方法进行数据库操作
        String id  = companyMapper.findCompanyIdByCompanyName(catalogName);

        //5,释放资源
        sqlSession.close();
        return id;
    }

    public PageInfo findByPage(int currentPage, int pageSize) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2,获取代理对象
        CompanyMapper companyMapper = sqlSession.getMapper(CompanyMapper.class);

        PageHelper.startPage(currentPage,pageSize);

        //3,调用方法进行数据库操作
        List<Company> list = companyMapper.findAll();

        //4,将list数据封装到PageInfo对象中
        PageInfo info = new PageInfo(list);

        //5,释放资源
        sqlSession.close();
        return info;
    }

    public void add(Company company) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2,获取代理对象
        CompanyMapper studentMapper = sqlSession.getMapper(CompanyMapper.class);
        //生成id
        String id = UUID.randomUUID().toString();
        company.setId(id);
        //3,调用方法进行数据库操作
        studentMapper.add(company);
        //4,释放资源
        sqlSession.close();
    }

    public void update(Company company) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession(false);
        //2,获取代理对象
        CompanyMapper studentMapper = sqlSession.getMapper(CompanyMapper.class);
        //3,调用方法进行数据库操作
        studentMapper.update(company);
        //4,释放资源，提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(String id) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2,获取代理对象
        CompanyMapper studentMapper = sqlSession.getMapper(CompanyMapper.class);
        //3,调用方法进行数据库操作
        studentMapper.delete(id);
        //4,释放资源
        sqlSession.close();
    }
}
