package com.mochi.springboot.gift.common.utils.redisUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author Mochi
 * @Description TODO
 * @Date 2019/9/27 14:09
 * @Name RedisUtil
 */
@Component
@Slf4j
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("超时时间设置异常:" + e);
            return false;
        }
    }

    /**
     * @Author Mochi
     * @Description TODO 删除redis数据,支持多个key
     * @Date 14:12 2019/9/27
     * @Param [key]
     * @Return void
     **/
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * @Author Mochi
     * @Description TODO 根据key获取redis值
     * @Date 14:13 2019/9/27
     * @Param [key]
     * @Return java.lang.Object
     **/
    public Object get(String key) {
        return StringUtils.isEmpty(key) ? null : redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.info("key=" + key + ",redis缓存失败:" + e);
            return false;
        }
    }

    public boolean set(String key, Object value, long expireTime) {
        try {
            redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.info("key=" + key + ",redis缓存失败:" + e);
            return false;
        }
    }

    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            log.info("key=" + key + ",redis缓存失败:" + e);
            return false;
        }
    }

    public boolean hmset(String key, Map<String, Object> map, long expireTime) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            expire(key, expireTime);
            return true;
        } catch (Exception e) {
            log.info("key=" + key + ",redis缓存失败:" + e);
            return false;
        }
    }
}
