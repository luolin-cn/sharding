package com.lin.sharding.infra.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

public class MyDsPreciseAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        // 实现按照=或in进行精确分片
        // 例如 SELECT * from t_order where order_id in (1,3) or order_id=10
        // 实现ds$->{0..1}
        BigInteger shardingValue = BigInteger.valueOf(preciseShardingValue.getValue());
        BigInteger res = shardingValue.mod(new BigInteger("2"));
        String key = "ds"+res;
        if(collection.contains(key)){
            return key;
        }
        throw new RuntimeException("there is no such ds,key:"+key);
    }
}
