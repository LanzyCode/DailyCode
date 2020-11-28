package com.lanzycode.service;

import com.github.pagehelper.PageInfo;
import com.lanzycode.domain.Company;

import java.util.List;

public interface CompanyService {
    /**
     * 分页查询
     * @param currentPage  ： 当前页码
     * @param pageSize  ： 每页显示的条目数
     * @return
     */
    PageInfo findByPage(int currentPage, int pageSize);

    /**
     * 添加企业数据
     * @param company  ： 封装企业数据的对象
     */
    void add(Company company);

    /**
     * 修改企业数据
     * @param company  ： 封装企业数据的对象
     */
    void update(Company company);

    /**
     * 删除学生信息
     * @param id  ： 主键id
     */
    void delete(String id);

    List<Company> findAll();

    String findCompanyIdByCompanyName(String catalogName);
}
