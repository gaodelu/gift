package com.mochi.springboot.gift.login;

import com.mochi.springboot.gift.common.utils.mailUtils.MailUtils;
import com.mochi.springboot.gift.common.utils.redisUtils.RedisUtil;
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
    private LoginService loginService;

    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody UserInfo userInfo) {
        logger.info("Login Start:" + userInfo);
        String loginstate = loginService.doLogin(userInfo);
        if (StringUtils.isEmpty(loginstate)) {
            return super.failure("LULUERR-00001", "账户或密码错误");
        } else {
            Map<String, Object> result = new HashMap<>();
            result.put("loginId", loginstate);
            return super.success(result);
        }

    }
}
