package com.gaoxi.test.chain.test;

import com.gaoxi.test.chain.base.AbstractRequest;
import com.gaoxi.test.chain.base.AbstractResponse;
import com.gaoxi.test.chain.context.TransContext;
import com.gaoxi.test.chain.convert.TransConvert;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/20
 */
public class CreateOrderConvert implements TransConvert {
    @Override
    public TransContext request2TransContext(AbstractRequest req, TransContext context) {
        CreateOrderRequest createOrderRequest=(CreateOrderRequest)req;
        CreateOrderContext createOrderContext=(CreateOrderContext) context;
        createOrderContext.setDesc(createOrderRequest.getDesc());
        createOrderContext.setOrderId(createOrderRequest.getOrderId());
        return createOrderContext;
    }

    @Override
    public AbstractResponse context2Response(TransContext context) {
        CreateOrderContext createOrderContext=(CreateOrderContext) context;
        CreateOrderResponse createOrderResponse=new CreateOrderResponse();
        createOrderResponse.setOrderId(createOrderContext.getOrderId());
        createOrderResponse.setDesc(createOrderContext.getDesc());
        createOrderResponse.setCode("0000");
        createOrderResponse.setMsg("请求成功");
        return createOrderResponse;
    }
}
