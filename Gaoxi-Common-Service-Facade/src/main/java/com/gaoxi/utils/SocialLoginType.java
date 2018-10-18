package com.gaoxi.utils;

/**
 * @ClassName SocialLoginType
 * @Author wh
 * @Date 2018/10/15
 * @Version 1.0.0
 */
public enum SocialLoginType {
    WEI_XIN(1, "微信"),
    QQ(2, "qq"),
    WEI_BO(3, "微博");
    public int code;

    public String type;

    private SocialLoginType(int code, String type) {
        this.code = code;
        this.type = type;
    }

}
