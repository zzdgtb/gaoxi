package com.gaoxi.test.chain.test;

import com.gaoxi.test.chain.context.AbsTransContext;
import com.gaoxi.test.chain.pipeline.TransPipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/20
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args){
        CreateOrderResponse response = new CreateOrderResponse();
        CreateOrderRequest request = new CreateOrderRequest();
        CreateOrderPipelineFactory createOrderPipelineFactory = new CreateOrderPipelineFactory();
        try {
            TransPipeline pipeline = createOrderPipelineFactory.build(request);
            pipeline.start(); //启动流程（pipeline来处理）
            AbsTransContext context = pipeline.getContext();
            response = (CreateOrderResponse) context.getConvert().context2Response(context);
        } catch (Exception e) {
            logger.error("OrderCoreServiceImpl.createOrder Occur Exception :" + e);
        }
        logger.info(response.getDesc());
    }
}
