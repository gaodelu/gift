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

    private String password;//密码
/*

    private int sex; //性别  0-男,1-女

    private String email;//邮箱

    private String mobile;//手机号

    private String nickName;//昵称
*/

}
