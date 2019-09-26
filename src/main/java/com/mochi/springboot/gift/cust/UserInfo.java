package com.mochi.springboot.gift.cust;

import lombok.Data;

/**
 * @Author Mochi
 * @Description TODO 用户登录类
 * @Date 2019/9/7 2:00
 * @Name UserInfo
 */
@Data
public class UserInfo {

    private String id;//主键id

    private String username;//登录用户名

    private String password;//密码  (改用BASE64加密)
}
