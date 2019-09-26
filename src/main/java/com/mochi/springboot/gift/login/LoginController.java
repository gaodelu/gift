package com.mochi.springboot.gift.login;

import com.mochi.springboot.gift.common.utils.webUtils.BaseController;
import com.mochi.springboot.gift.cust.UserInfo;
import com.mochi.springboot.gift.cust.UserInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/LoginController")
public class LoginController extends BaseController {

    Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/login")
    public Map<String, Object> login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        logger.info("Login Start");
        if (StringUtils.isEmpty(userName)) {
            logger.info("请求的用户名为空");
        }
        if (StringUtils.isEmpty(password)) {
            logger.info("请求的密码为空");
        }
        if ("admin".equals(userName) && "123456".equals(password)) {
            logger.info("Login Success");
        } else {
            logger.info("Login Denied");
        }
        UserInfo userInfo = userInfoService.findByUserName(userName);
        logger.info(userInfo.getPassword());
        return new HashMap<>();
    }
}
