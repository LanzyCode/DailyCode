package com.itheima.service;

import com.itheima.domain.Question;
import com.itheima.domain.QuestionItem;

import java.util.List;

public interface QuestionItemService {
    List<QuestionItem> findByQuestionId(String questionId);

    void update(String questionId, List<QuestionItem> list);
}
