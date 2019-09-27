package com.mochi.springboot.gift.login;

import com.mochi.springboot.gift.common.utils.mailUtils.MailUtils;
import com.mochi.springboot.gift.common.utils.redisUtils.RedisUtil;
import com.mochi.springboot.gift.cust.UserInfo;
import com.mochi.springboot.gift.cust.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.UUID;

@Service
@Slf4j
public class LoginService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisUtil redisUtil;

    public String doLogin(UserInfo userInfo) {
        String loginId = "";
        log.info("11111111111111111");
        UserInfo user = userInfoMapper.findByUserName(userInfo.getUsername());
        if (user.getPassword().equals(new String(Base64.getDecoder().decode(userInfo.getPassword())))) {
            //如果是第一次登录,发送邮件欢迎...
            new Thread(() -> {
                try {
                    MailUtils.sendMail("1023079651@qq.com", "念思思", "工作时候想念,快乐无穷~~mua~~~本邮件由可爱的露露软件发送~~~");
                    Thread.sleep(10000);
                } catch (Exception e) {
                    log.error("邮件发送异常" + e);
                }
            }).start();
            //登录成功,信息上送redis,将key返回
            loginId = UUID.randomUUID().toString();
            redisUtil.set(loginId, "1");
        }
        return loginId;
    }
}
