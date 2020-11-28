package com.itheima.service.impl;

import com.itheima.dao.QuestionItemMapper;
import com.itheima.domain.Question;
import com.itheima.domain.QuestionItem;
import com.itheima.service.QuestionItemService;
import com.itheima.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class QuestionItemServiceImpl implements QuestionItemService {
    public List<QuestionItem> findByQuestionId(String questionId) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        QuestionItemMapper questionItemMapper = sqlSession.getMapper(QuestionItemMapper.class);

        List<QuestionItem> list = questionItemMapper.findByQuestionId(questionId);

        sqlSession.close();
        return list;
    }

    public void update(String questionId,List<QuestionItem> list) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        QuestionItemMapper questionItemMapper = sqlSession.getMapper(QuestionItemMapper.class);
        //删除题目关联的选项
        questionItemMapper.deleteByQuestionId(questionId);
        //添加题目选项表中的数据
        for (QuestionItem questionItem : list) {
            String id = UUID.randomUUID().toString();
            questionItem.setId(id);
            questionItem.setQuestionId(questionId);
            questionItemMapper.add(questionItem);
        }
    }
}
