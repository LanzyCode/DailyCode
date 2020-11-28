package com.itheima.service;

import com.itheima.domain.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void delete(String deptId);

    void update(Dept dept);

    void add(Dept dept);
}
