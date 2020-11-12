package com.lanzycode.table01;

import com.lanzycode.bean.Card;

import java.util.List;

public interface OneToOneMapper {
    //查询全部
    public abstract List<Card> selectAll();
}
