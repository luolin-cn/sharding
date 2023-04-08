package com.lin.sharding.infra.mapper;

import com.lin.sharding.api.dto.OrderDTO;
import com.lin.sharding.domain.entity.Order;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

    List<Order> selectPlus(OrderDTO order);
}
