package com.lin.sharding.infra.mapper;

import com.lin.sharding.api.dto.OrderDTO;
import com.lin.sharding.domain.entity.Order;
import com.lin.sharding.domain.entity.OrderItem;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface OrderItemMapper extends BaseMapper<OrderItem> {

    List<OrderItem> selectPlus(OrderDTO order);
}
