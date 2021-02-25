package com.gaoxi.test.chain2.test;

import com.gaoxi.test.chain2.base.AbstractResponse;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/20
 */
public class CreateOrderResponse extends AbstractResponse {
    /**
     * id
     */
    private Long orderId;
    /**
     * 描述
     */
    private String desc;

    public Long getOrderId() {
        return orderId;
    }

    public CreateOrderResponse setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public CreateOrderResponse setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
