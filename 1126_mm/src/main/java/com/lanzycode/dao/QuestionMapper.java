package com.lanzycode.dao;

import com.lanzycode.domain.Question;

import java.util.List;

public interface QuestionMapper {

    List<Question> findAll();

    void add(Question question);

    void update(Question question);

    void delete(String id);
}
