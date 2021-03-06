package com.lanzycode.dao;

import com.lanzycode.domain.Dept;

import java.util.List;

public interface DeptMapper {

    List<Dept> findLeval1(Object o);

    List<Dept> findByParentId(String parentId);

    void add(Dept dept);

    void update(Dept dept);

    void delete(String deptId);
}
