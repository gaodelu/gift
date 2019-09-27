package com.mochi.springboot.gift.common.config.mailConfig;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author Mochi
 * @Description TODO
 * @Date 2019/9/26 15:22
 * @Name mailConfig
 */
@Data
@Component
public class MailConfig {
    private static final String PROPERTIES_DEFAULT = "mailConfig.properties";
    public static String host;
    public static Integer port;
    public static String userName;
    public static String passWord;
    public static String emailForm;
    public static String timeout;
    public static String personal;
    public static String subject;
    public static String html;
    public static Properties properties;
    static{
        init();
    }

    /**
     * 初始化
     */
    private static void init() {
        properties = new Properties();
        try{
            InputStream inputStream = MailConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_DEFAULT);
            properties.load(inputStream);
            inputStream.close();
            //properties.setProperty("mailFrom","cuizhixiang@feitu.biz");
            host = properties.getProperty("mailHost");
            port = Integer.parseInt(properties.getProperty("mailPort"));
            userName = properties.getProperty("mailUsername");
            passWord = properties.getProperty("mailPassword");
            emailForm = properties.getProperty("mailFrom");
            timeout = properties.getProperty("mailTimeout");
            personal = properties.getProperty("mailPersonal");
            subject = properties.getProperty("mailSubject");
            html = properties.getProperty("mailHtml");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

