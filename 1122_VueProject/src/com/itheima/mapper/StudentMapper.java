package com.itheima.mapper;

import com.itheima.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 学生管理的dao层接口
 */
public interface StudentMapper {

    /**
     * 查询所有的数据
     * @return
     */
    @Select("select * from student")
    List<Student> findByPage();

    /**
     * 添加学生
     * @param stu
     */
    @Insert("insert into student values (#{number},#{name},#{birthday},#{address})")
    void add(Student stu);

    /**
     * 修改学生
     * @param stu
     */
    @Update("update student set name=#{name},birthday=#{birthday},address=#{address} where number = #{number}")
    void update(Student stu);

    /**
     * 根据id删除学生数据
     * @param id
     */
    @Delete("delete from student where number = #{number}")
    void delete(String id);
}
