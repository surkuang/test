package com.fpi.test.service;

import com.fpi.test.mapper.UserInfoMapper;
import com.fpi.test.model.PageData;
import com.fpi.test.model.Role;
import com.fpi.test.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public Object pagingUserInfo(Integer offset,Integer limit) {

        return new PageData<>(userInfoMapper.listUserInfo(offset,limit),10);
    }

    public List<Role> listRole(){
        return userInfoMapper.listRole();
    }
}
