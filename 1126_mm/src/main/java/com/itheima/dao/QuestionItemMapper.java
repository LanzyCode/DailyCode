package com.itheima.dao;

import com.itheima.domain.QuestionItem;

import java.util.List;

public interface QuestionItemMapper {

    List<QuestionItem> findByQuestionId(String questionId);

    void deleteByQuestionId(String questionId);

    void add(QuestionItem questionItem);
}
