package com.gaoxi.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <p>Description:错误定义 </p>
 *
 * @author wh
 * @version 1.0.0
 * @date 2018年10月12日
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ApiErrorType {

    SYSTEM_ERROR("500", "系统错误"),
    PARAMER_ERROR("502", "参数错误"),
    VERIFY_CODE_ERROR("504", "验证码错误"),
    UNKNOW_USER("506", "未知账号");

    public String code;
    public String msg;


}
