package com.mochi.springboot.gift.login;

import com.mochi.springboot.gift.common.utils.webUtils.BaseController;
import com.mochi.springboot.gift.cust.UserInfo;
import com.mochi.springboot.gift.cust.UserInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/LoginController")
public class LoginController extends BaseController {

    Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody UserInfo userInfo) {
        logger.info("Login Start:" + userInfo);
        UserInfo user = userInfoService.findByUserName(userInfo.getUsername());
        if (user.getPassword().equals(new String(Base64.getDecoder().decode(userInfo.getPassword())))) {
            logger.info("Login Success");
            return success();
        } else {
            logger.info("Login Fail");
            return failure("LULU-00001", "账号或密码错误!");
        }
    }
}
