package com.gaoxi.test.chain2.test;

import com.gaoxi.test.chain2.base.AbstractRequest;
import com.gaoxi.test.chain2.base.AbstractResponse;
import com.gaoxi.test.chain2.context.BaseContext;
import com.gaoxi.test.chain2.convert.BaseConvert;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/29
 */
public class CreateOrderConvert implements BaseConvert {

    @Override
    public BaseContext request2Context(AbstractRequest abstractRequest) {
        CreateOrderRequest createOrderRequest=(CreateOrderRequest)abstractRequest;
        CreateOrderContext createOrderContext=new CreateOrderContext();
        createOrderContext.setDesc(createOrderRequest.getDesc());
        createOrderContext.setOrderId(createOrderRequest.getOrderId());
        return createOrderContext;
    }

    @Override
    public AbstractResponse context2Response(BaseContext baseContext) {
        CreateOrderContext createOrderContext=(CreateOrderContext) baseContext;
        CreateOrderResponse createOrderResponse=new CreateOrderResponse();
        createOrderResponse.setOrderId(createOrderContext.getOrderId());
        createOrderResponse.setDesc(createOrderContext.getDesc());
        createOrderResponse.setCode("0000");
        createOrderResponse.setMsg("请求成功");
        return createOrderResponse;
    }
}
