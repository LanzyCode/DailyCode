package com.lanzycode.many_to_many;

import com.lanzycode.bean.Student;
import com.lanzycode.sql.ReturnSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    //查询全部
//    @Select("SELECT DISTINCT s.id,s.name,s.age FROM student s,stu_cr sc WHERE sc.sid=s.id")
//    @Results({
//            @Result(column = "id",property = "id"),
//            @Result(column = "name",property = "name"),
//            @Result(column = "age",property = "age"),
//            @Result(
//                    property = "courses",   // 被包含对象的变量名
//                    javaType = List.class,  // 被包含对象的实际数据类型
//                    column = "id",          // 根据查询出student表的id来作为关联条件，去查询中间表和课程表
//                    /*
//                        many、@Many 一对多查询的固定写法
//                        select属性：指定调用哪个接口中的哪个查询方法
//                     */
//                    many = @Many(select = "com.itheima.many_to_many.CourseMapper.selectBySid")
//            )
//    })
//    public abstract List<Student> selectAll();

    @SelectProvider(type = ReturnSql.class , method = "getSelectAll")
    public abstract List<Student> selectAll();

    //新增功能
    //@Insert("INSERT INTO student VALUES (#{id},#{name},#{age})")
    @InsertProvider(type = ReturnSql.class , method = "getInsert")
    public abstract Integer insert(Student stu);

    //修改功能
    //@Update("UPDATE student SET name=#{name},age=#{age} WHERE id=#{id}")
    @UpdateProvider(type = ReturnSql.class , method = "getUpdate")
    public abstract Integer update(Student stu);

    //删除功能
    //@Delete("DELETE FROM student WHERE id=#{id}")
    @DeleteProvider(type = ReturnSql.class , method = "getDelete")
    public abstract Integer delete(Integer id);
}
