package com.tuc.myself.blog.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: tuc
 * @Date: 2020-03-03 8:45
 */
@Component
public class RedisUtils<K, V> {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void set(K key, V value) {
        BoundValueOperations<K, V> valueOper = redisTemplate.boundValueOps(key);
        valueOper.set(value);
    }

    public void set(K key, V value, long expiredTime) {
        BoundValueOperations<K, V> valueOper = redisTemplate.boundValueOps(key);
        if (expiredTime <= 0) {
            valueOper.set(value);
        } else {
            valueOper.set(value, expiredTime, TimeUnit.SECONDS);
        }
    }

    public V get(K key) {
        BoundValueOperations<K, V> valueOper = redisTemplate.boundValueOps(key);
        return valueOper.get();
    }

    public Object getHash(K key, String name) {
        Object res = redisTemplate.boundHashOps(key).get(name);
        return res;
    }

    public void del(K key) {
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
        }
    }

    public boolean isExist(K key) {
        if (redisTemplate.hasKey(key)) {
            return true;
        }else{
            return false;
        }
    }

    public Set<String> getKeys(String key) {
        return stringRedisTemplate.keys(key);
    }
}
