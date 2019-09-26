package com.mochi.springboot.gift.common.utils.webUtils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public Map<String, Object> success() {
        Map<String, Object> head = new HashMap<>();
        head.put("retCode", "00000");
        head.put("retMsg", "处理成功");
        return head;
    }

    public Map<String, Object> success(Object obj) {
        Map<String, Object> result = new HashMap<>();
        result.put("head", success());
        result.put("body", obj);
        return result;
    }

    public Map<String, Object> failure(String errCode, String errMsg) {
        Map<String, Object> head = new HashMap<>();
        head.put("retCode", errCode);
        head.put("retMsg", errMsg);
        return head;
    }
}

