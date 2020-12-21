package com.fpi.test.api;

import com.fpi.test.cache.TestCache;
import com.fpi.test.model.UserInfo;
import com.fpi.test.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Validated
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private TestCache testCache;

    @GetMapping
    public Object pageUserInfo(@RequestHeader(value = "TEST",required = false)String test, @RequestParam(defaultValue = "0")int offset,@RequestParam(defaultValue = "10")int limit){

        testCache.testCache(test);
        return userInfoService.pagingUserInfo(offset,limit);
    }

    @GetMapping("/cache")
    public Set<String> getCache(){
        return testCache.getCache();
    }


}
