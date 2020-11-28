package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Catalog;

import java.util.List;

public interface CatalogService {

    PageInfo findByPage(int currentPage);

    void add(Catalog catalog);

    void update(Catalog catalog);

    void delete(String id);

    List<Catalog> findAll();

    String findCatalogIdByCatalogName(String catalogName);
}
