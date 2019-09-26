package com.mochi.springboot.gift.cust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo findByUserName(String userName) {
        return userInfoMapper.findByUserName(userName);
    }
}
