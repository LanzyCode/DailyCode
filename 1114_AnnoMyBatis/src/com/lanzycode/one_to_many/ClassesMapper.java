package com.lanzycode.one_to_many;

import com.lanzycode.bean.Classes;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassesMapper {
    //查询全部
    @Select("SELECT * FROM classes")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(
                    property = "students",//被包含对象的变量名
                    javaType = List.class,//被包含对象的数据类型
                    column = "id",        //根据classes的id字段去查询学生表

                    many=@Many(select = "com.lanzycode.one_to_many.StudentMapper.selectByCid")
            )

    })
    public abstract List<Classes> selectAll();
}
