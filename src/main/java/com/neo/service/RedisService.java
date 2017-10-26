package com.neo.service;

import com.neo.entity.SecKill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by zouxiang on 2017/9/25.
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public SecKill getSecKill(int key){
        SecKill secKill = (SecKill) redisTemplate.opsForValue().get("secKill"+key);
        return secKill;
    }


    public void putSecKill(SecKill secKill){
        redisTemplate.opsForValue().set("secKill"+secKill.getId(),secKill);
    }

    public void updateSecKill(int goodsId) {
        SecKill secKill = getSecKill(goodsId);
        secKill.setRemainNum(secKill.getRemainNum() - 1);
        putSecKill(secKill);
    }

}
