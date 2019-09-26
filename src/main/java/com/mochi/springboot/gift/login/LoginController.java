package com.mochi.springboot.gift.login;

import com.mochi.springboot.gift.common.utils.mailUtils.MailUtils;
import com.mochi.springboot.gift.common.utils.webUtils.BaseController;
import com.mochi.springboot.gift.cust.UserInfo;
import com.mochi.springboot.gift.cust.UserInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
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
            new Thread(() -> {
                try {
                    MailUtils.sendMail("1023079651@qq.com", "思思是笨蛋", "本邮件由可爱的露露软件发送~~~");
                } catch (Exception e) {
                    logger.error("邮件发送异常" + e);
                }
            }).start();
            return success();
        } else {
            logger.info("Login Fail");
            return failure("LULU-00001", "账号或密码错误!");
        }
    }
}
