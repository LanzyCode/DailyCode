package com.lanzycode.service;

import com.lanzycode.domain.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void delete(String deptId);

    void update(Dept dept);

    void add(Dept dept);
}
