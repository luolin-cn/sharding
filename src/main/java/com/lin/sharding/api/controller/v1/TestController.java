package com.lin.sharding.api.controller.v1;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.lin.sharding.domain.entity.Order;
import com.lin.sharding.infra.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private OrderMapper orderMapper;
    @PostMapping("/insert")
    public String insert(){
        for (int i = 1; i < 100; i++) {
            Order order = new Order();
            order.setOrderId((long) i);
            order.setName("order_"+i);
            int userId = i + i;
            order.setUserId((long) userId);
            System.out.println(JSONUtil.toJsonStr(order));
            orderMapper.insert(order);
        }
        return "success";
    }
}
