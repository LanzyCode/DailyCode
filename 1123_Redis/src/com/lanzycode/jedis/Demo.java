package com.lanzycode.jedis;

import redis.clients.jedis.Jedis;

public class Demo {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("150.158.173.105",6379);
        jedis.set("name", "lanzy");
        System.out.println(jedis.get("name"));
        jedis.close();
    }
}
