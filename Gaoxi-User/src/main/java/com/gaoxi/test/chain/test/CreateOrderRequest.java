package com.gaoxi.test.chain.test;

import com.gaoxi.test.chain.base.AbstractRequest;

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

    @Override
    public void requestCheck() {

    }

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
