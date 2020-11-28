package com.lanzycode.service;

import com.github.pagehelper.PageInfo;
import com.lanzycode.domain.Question;

public interface QuestionService {

    PageInfo findByPage(int currentPage);

    void add(Question question);

    void update(Question question);

    void delete(String id);
}
