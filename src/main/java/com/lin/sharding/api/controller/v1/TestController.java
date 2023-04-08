package com.lin.sharding.api.controller.v1;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lin.sharding.api.dto.OrderDTO;
import com.lin.sharding.api.dto.OrderItemDTO;
import com.lin.sharding.api.dto.PageRequet;
import com.lin.sharding.domain.entity.Order;
import com.lin.sharding.domain.entity.OrderItem;
import com.lin.sharding.infra.mapper.OrderItemMapper;
import com.lin.sharding.infra.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
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

    @GetMapping("/query")
    public List<Order> query(Order order){
        return orderMapper.select(order);
    }

    @GetMapping("/query-plus")
    public List<Order> queryPlus(OrderDTO orderDTO){
        return orderMapper.selectPlus(orderDTO);
    }

    @GetMapping("page")
    public Page<Order> page(OrderDTO orderDTO, PageRequet pageRequet){
        return PageHelper.startPage(pageRequet.getPageNum(), pageRequet.getPageSize()).doSelectPage(()-> orderMapper.selectPlus(orderDTO));
    }
    @GetMapping("/query-item")
    public List<OrderItem> queryItem(OrderItem order){
        return orderItemMapper.select(order);
    }
}
