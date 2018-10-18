package com.gaoxi.model.user.vo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName GetplayUrlVO
 * @Author admin
 * @Date 2018/10/15
 * @Version 1.0.0
 */
@Data
public class GetplayUrlVO {

    /**
     * 主播id
     */
    @NotBlank
    private int userid;
}
