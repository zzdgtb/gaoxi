package com.gaoxi.test.chain2.test;

import com.gaoxi.test.chain2.context.BaseContext;
import com.gaoxi.test.chain2.pipleline.BasePipleLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/29
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args)throws Exception{
        CreateOrderResponse response = new CreateOrderResponse();
        CreateOrderRequest request = new CreateOrderRequest();
        CreateOrderPipelineFactory createOrderPipelineFactory = new CreateOrderPipelineFactory();
        try {
            BasePipleLine pipeline = createOrderPipelineFactory.createPipleLine(request);
            pipeline.start(); //启动流程（pipeline来处理）
            Thread.sleep(1000);
            BaseContext context = pipeline.getContext();
            response = (CreateOrderResponse) createOrderPipelineFactory.createConvert(request).context2Response(context);
        } catch (Exception e) {
            logger.error("OrderCoreServiceImpl.createOrder Occur Exception :" + e);
        }
        logger.info(response.getDesc());
    }
}
