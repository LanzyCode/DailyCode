package com.lanzycode.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanzycode.dao.CatalogMapper;
import com.lanzycode.domain.Catalog;
import com.lanzycode.service.CatalogService;
import com.lanzycode.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class CatalogServiceImpl implements CatalogService {

    public PageInfo findByPage(int currentPage) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        CatalogMapper catalogMapper = sqlSession.getMapper(CatalogMapper.class);

        PageHelper.startPage(currentPage,5);
        //调用查询方法
        List<Catalog> list = catalogMapper.findAll();

        PageInfo pageInfo = new PageInfo(list);

        sqlSession.close();
        return pageInfo;
    }

    public List<Catalog> findAll() {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        CatalogMapper catalogMapper = sqlSession.getMapper(CatalogMapper.class);
        //调用查询方法
        List<Catalog> list = catalogMapper.findAll();

        sqlSession.close();
        return list;
    }

    public String findCatalogIdByCatalogName(String catalogName) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        CatalogMapper catalogMapper = sqlSession.getMapper(CatalogMapper.class);
        //调用查询方法
        String catalogId = catalogMapper.findCatalogIdByCatalogName(catalogName);

        sqlSession.close();
        return catalogId;
    }

    public void add(Catalog catalog) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        CatalogMapper catalogMapper = sqlSession.getMapper(CatalogMapper.class);

        String id = UUID.randomUUID().toString();
        catalog.setId(id);
        //调用添加方法
        catalogMapper.add(catalog);

        sqlSession.close();
    }

    public void update(Catalog catalog) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        CatalogMapper catalogMapper = sqlSession.getMapper(CatalogMapper.class);
        //调用添加方法
        catalogMapper.update(catalog);

        sqlSession.close();
    }

    public void delete(String id) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        CatalogMapper catalogMapper = sqlSession.getMapper(CatalogMapper.class);
        //调用添加方法
        catalogMapper.delete(id);

        sqlSession.close();
    }
}
