package com.gaoxi.model.user.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ClassName SocialLoginVO
 * @Author wh
 * @Date 2018/10/15
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialLoginVO {

    /**
     * 第三方唯一id
     */
    @NotEmpty
    private String ucode;

    private String unionId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 登录类型 1.微信  2.QQ 3.微博
     */
    @NotNull
    private Integer type;

    /**
     * 操作系统 1,安卓 2,IOS 3,小程序
     */
    @NotNull
    private Integer systemType;

    /**
     * 设备id
     */
    private String deviceId;
}
