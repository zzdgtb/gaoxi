package com.gaoxi.service.sms;

/**
 * <p>Description: 手机短信服务</p>
 *
 * @author wh
 * @version 1.0.0
 * @date 2018年10月12日
 */
public interface SmsService {
    /**
     * 短信发送
     *
     * @param phone
     * @return
     */
    String sendMsg(String phone);
}
