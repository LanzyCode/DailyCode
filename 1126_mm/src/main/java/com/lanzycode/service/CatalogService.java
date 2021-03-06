package com.lanzycode.service;

import com.github.pagehelper.PageInfo;
import com.lanzycode.domain.Catalog;

import java.util.List;

public interface CatalogService {

    PageInfo findByPage(int currentPage);

    void add(Catalog catalog);

    void update(Catalog catalog);

    void delete(String id);

    List<Catalog> findAll();

    String findCatalogIdByCatalogName(String catalogName);
}
