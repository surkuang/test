package com.fpi.test.mapper;

import com.fpi.test.service.UserInfoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoService userInfoMapper;


    @Test
    void listRole() {
        System.out.println(userInfoMapper.listRole());
        Assert.assertNotNull(userInfoMapper.listRole());
    }
}