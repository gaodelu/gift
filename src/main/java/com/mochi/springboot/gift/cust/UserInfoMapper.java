package com.mochi.springboot.gift.cust;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author Mochi
 * @Description TODO
 * @Date 2019/9/7 2:02
 * @Name UserInfoMapper
 */
@Repository
public interface UserInfoMapper {

    UserInfo findByUserName(String userName);
}
