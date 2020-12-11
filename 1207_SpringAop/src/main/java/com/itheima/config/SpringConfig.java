package com.itheima.config;


import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.itheima")
@PropertySource("classpath:com/itheima/jdbc.properties")
@Import({JDBCConfig.class,MyBatisConfig.class})
@EnableAspectJAutoProxy
public class SpringConfig {
}
