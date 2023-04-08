package com.lin.sharding.domain.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_order")
@Data
public class Order {
    @Id
    Long orderId;
    Long userId;
    String name;

}
