package com.lin.sharding.infra.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;

public class MyDsRangeAlgorithm implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        // 针对基于id经过运算出来的结果位置，反向计算所在的ds
        Long start = rangeShardingValue.getValueRange().lowerEndpoint();
        Long end = rangeShardingValue.getValueRange().upperEndpoint();
        return collection;
    }
}
