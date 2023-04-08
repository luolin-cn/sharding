package com.lin.sharding.api.dto;

import com.lin.sharding.domain.entity.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderItemDTO extends OrderItem {
    List<Long> orderIdList;
    Long orderIdStart;
    Long orderIdEnd;
}
