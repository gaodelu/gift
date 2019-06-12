package com.mochi.springboot.gift.login;

import com.mochi.springboot.gift.common.webUtils.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/LoginController")
public class LoginController extends BaseController {

    Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping(value = "/login")
    public Map<String, Object> login(String userName, String password) {
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
        return new HashMap<>();
    }
}
