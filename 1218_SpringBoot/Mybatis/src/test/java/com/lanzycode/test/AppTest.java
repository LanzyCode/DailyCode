package com.lanzycode.test;


import com.lanzycode.mapper.UserMapper;
import com.lanzycode.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll(){
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }
}
