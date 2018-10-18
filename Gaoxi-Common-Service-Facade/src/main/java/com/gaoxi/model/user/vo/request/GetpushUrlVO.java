package com.gaoxi.model.user.vo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName GetpushUrlVO
 * @Author admin
 * @Date 2018/10/15
 * @Version 1.0.0
 */
@Data
public class GetpushUrlVO {
    /**
     * 用户id
     */
    @NotBlank
    private int userid;
    /**
     * token
     */
    @NotBlank
    private String token;
}
