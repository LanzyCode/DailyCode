package com.itheima.factory;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 用于生成dao接口代理实现类的工厂
 *
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public abstract class MapperFactory {

    private static SqlSessionFactory FACTORY;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    static {
        //1.读取MyBatis文件
        try (InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");) {
            //2.创建SqlSessionFactory工厂类创建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.使用构建者创建SqlSessionFactory工厂
            FACTORY = builder.build(in);
        } catch (Exception e) {
            //打印异常信息到控制台
            e.printStackTrace();
            //抛出错误提示程序终止执行
            throw new ExceptionInInitializerError("初始化SqlSessionFactory失败!");
        }
    }

    /**
     * 获取SqlSession对象.
     * @return 保留此方法是为了后面对业务层方法增强,利用AOP添加事务.
     * @param b
     */
    public static SqlSession getSqlSession(boolean b) {
        return FACTORY.openSession(false);
    }

    /**
     * 获取Dao接口的代理实现类
     * @param daoClass dao接口字节码
     * @return
     */
    public static <T> T getMapper(SqlSession sqlSession, Class<T> daoClass) {
        //1.判断传入的SqlSession是否为null.
        if (sqlSession == null) {
            return null;
        }
        //2.不为null,创建代理实现类.
        return sqlSession.getMapper(daoClass);
    }
    @Insert("insert into User values (#{number},#{name},#{birthday},#{address})")
    public abstract void add(User user);
    @Select("select * from User")
    public abstract List<User> findByPage();
    @Update("update User set name=#{name},birthday=#{birthday},address=#{address} where number = #{number}")
    public abstract void update(User user);
    @Delete("delete from User where number = #{number}")
    public abstract void delete(String number);
}
