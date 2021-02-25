package com.gaoxi.test.chain2.test;

import com.gaoxi.test.chain2.context.BaseContext;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/29
 */
public class CreateOrderContext implements BaseContext {
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

    public CreateOrderContext setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public CreateOrderContext setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}