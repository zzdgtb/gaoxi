package com.gaoxi.test.chain2.test;

import com.gaoxi.test.chain2.base.AbstractRequest;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/20
 */
public class CreateOrderRequest extends AbstractRequest {
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

    public CreateOrderRequest setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public CreateOrderRequest setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
