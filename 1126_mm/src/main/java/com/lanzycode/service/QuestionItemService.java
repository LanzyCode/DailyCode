package com.lanzycode.service;

import com.lanzycode.domain.QuestionItem;

import java.util.List;

public interface QuestionItemService {
    List<QuestionItem> findByQuestionId(String questionId);

    void update(String questionId, List<QuestionItem> list);
}
