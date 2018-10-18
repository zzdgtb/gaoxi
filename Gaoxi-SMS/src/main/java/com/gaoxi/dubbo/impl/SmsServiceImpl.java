package com.gaoxi.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaoxi.service.sms.SmsService;

@Service(version = "1.0.0")
public class SmsServiceImpl implements SmsService {

    @Override
    public String sendMsg(String phone) {

        return "123456";
    }

}
