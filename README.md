# sharding
整合实际企业使用场景中通过shardingsphere进行分库分表操作

inline主要实现通过sharding-jdbc的inline进行分库分表操作


建表语句：
```sql
drop table t_order;
drop table t_order_0;
drop table t_order_1;
create table t_order
(
order_id bigint not null primary key,
user_id  bigint,
name     varchar(100)
);
create table t_order_0
(
    order_id bigint not null primary key,
    user_id  bigint,
    name     varchar(100)
);
create table t_order_1
(
    order_id bigint not null primary key,
    user_id  bigint,
    name     varchar(100)
);
```