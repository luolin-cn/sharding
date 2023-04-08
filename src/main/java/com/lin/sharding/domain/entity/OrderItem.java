package com.lin.sharding.domain.entity;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name ="t_order_item")
@Data
public class OrderItem {
    @Id
    int orderItemId;
    int orderId;
    int userId;
    String item;
}
