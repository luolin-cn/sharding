package com.lin.sharding.api.dto;

import com.lin.sharding.domain.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO extends Order {
    List<Long> orderIdList;
}
