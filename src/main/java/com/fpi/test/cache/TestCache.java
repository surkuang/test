package com.fpi.test.cache;

import com.fpi.test.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class TestCache {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private static final String TESTCACHE = "test:user";

    /**
     * 测试缓存
     * @param userId
     */
    public void testCache(String userId){

        redisTemplate.opsForSet().add(TESTCACHE,userId);
    }

    /**
     * 获取缓存中的user
     */
    public Set<String> getCache(){
        return redisTemplate.opsForSet().members(TESTCACHE);
    }

}
