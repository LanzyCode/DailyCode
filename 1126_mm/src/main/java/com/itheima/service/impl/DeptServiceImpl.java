package com.itheima.service.impl;

import com.itheima.dao.CompanyMapper;
import com.itheima.dao.DeptMapper;
import com.itheima.domain.Dept;
import com.itheima.service.DeptService;
import com.itheima.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class DeptServiceImpl implements DeptService {

    public List<Dept> findAll() {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2,获取代理对象
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);

        List<Dept> list = deptMapper.findLeval1(null);

        //遍历
        for (Dept dept : list) {
            List<Dept> list1 = deptMapper.findByParentId(dept.getDeptId());
            dept.setChildren(list1);
            for (Dept dept1 : list1) {
                List<Dept> list2 = deptMapper.findByParentId(dept1.getDeptId());
                dept1.setChildren(list2);
            }
        }
        //4,释放资源
        sqlSession.close();
        return list;
    }

    public void delete(String deptId) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2,获取代理对象
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);

        deptMapper.delete(deptId);

        sqlSession.commit();
        //4,释放资源
        sqlSession.close();
    }

    public void update(Dept dept) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2,获取代理对象
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);

        deptMapper.update(dept);
        //4,释放资源
        sqlSession.close();
    }

    public void add(Dept dept) {
        //1,获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2,获取代理对象
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);

        String id = UUID.randomUUID().toString();
        dept.setDeptId(id);
        deptMapper.add(dept);
        //4,释放资源
        sqlSession.close();
    }
}
