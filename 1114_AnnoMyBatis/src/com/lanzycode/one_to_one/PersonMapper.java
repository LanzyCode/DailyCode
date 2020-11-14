package com.lanzycode.one_to_one;

import com.lanzycode.bean.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
    //根据id查询
    @Select("SELECT * FROM person WHERE id=#{id}")
    public abstract Person selectById(Integer id);
}
