package com.lanzycode.dao;

import com.lanzycode.domain.Catalog;

import java.util.List;

public interface CatalogMapper {
    
    List<Catalog> findAll();

    void add(Catalog catalog);

    void update(Catalog catalog);

    void delete(String id);

    String findCatalogIdByCatalogName(String catalogName);
}
