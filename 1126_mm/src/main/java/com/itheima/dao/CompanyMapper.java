package com.itheima.dao;

import com.itheima.domain.Company;

import java.util.List;

public interface CompanyMapper {

    List<Company> findAll();

    void add(Company company);

    void update(Company company);

    void delete(String id);

    String findCompanyIdByCompanyName(String catalogName);
}
