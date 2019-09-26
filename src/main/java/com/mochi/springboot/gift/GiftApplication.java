package com.mochi.springboot.gift;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Mochi
 * @Description TODO  程序入口类
 * @Date 12:58 2019/9/7
 * @Param
 * @Return
 **/
@MapperScan("com.mochi.springboot.gift.*")
@SpringBootApplication
public class GiftApplication {
    public static void main(String[] args) {
        SpringApplication.run(GiftApplication.class, args);
    }

}
