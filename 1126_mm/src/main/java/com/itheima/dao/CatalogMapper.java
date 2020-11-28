package com.itheima.dao;

import com.itheima.domain.Catalog;

import java.util.List;

public interface CatalogMapper {
    
    List<Catalog> findAll();

    void add(Catalog catalog);

    void update(Catalog catalog);

    void delete(String id);

    String findCatalogIdByCatalogName(String catalogName);
}
