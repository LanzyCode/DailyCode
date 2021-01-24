package com.itheima.consumer.feign;

import com.itheima.consumer.domain.Goods;
import org.springframework.stereotype.Component;

@Component//将该类bean加入springMVC容器
public class GoodsFeignClientFallback implements GoodsFeignClient{
    @Override
    public Goods findGoodsById(int id) {
        Goods goods = new Goods();
        goods.setTitle("又被降级了");
        return goods;
    }
}
