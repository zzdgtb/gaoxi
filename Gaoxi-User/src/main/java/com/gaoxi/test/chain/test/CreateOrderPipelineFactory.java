package com.gaoxi.test.chain.test;

import com.gaoxi.test.chain.callback.TransCallBack;
import com.gaoxi.test.chain.context.TransContext;
import com.gaoxi.test.chain.convert.TransConvert;
import com.gaoxi.test.chain.factory.AbstranctTransPipelineFactory;
import com.gaoxi.test.chain.handle.AbstractTransHandler;
import com.gaoxi.test.chain.pipeline.TransPipeline;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/20
 */
public class CreateOrderPipelineFactory extends AbstranctTransPipelineFactory<CreateOrderRequest> {

    @Override
    protected TransContext createContext() {
        return new CreateOrderContext();
    }

    @Override
    protected void doBuild(TransPipeline pipeline) {
        pipeline.addFirst(new AbstractTransHandler() {
            @Override
            public boolean isAsync() {
                return true;
            }

            @Override
            public boolean handle(TransContext context) {
                CreateOrderContext createOrderContext=(CreateOrderContext)context;
                createOrderContext.setOrderId(1L);
                createOrderContext.setDesc(" first handler!"+createOrderContext.getDesc());
                return true;
            }
            @Override
            public TransCallBack getTransCallback(){
               return new SendMsgCallBack();
            }
        });
        pipeline.addFirst(new AbstractTransHandler() {
            @Override
            public boolean isAsync() {
                return false;
            }

            @Override
            public boolean handle(TransContext context) {
                CreateOrderContext createOrderContext=(CreateOrderContext)context;
                createOrderContext.setOrderId(1L);
                createOrderContext.setDesc(" second handler!"+createOrderContext.getDesc());
                return true;
            }
        });
        pipeline.addFirst(new AbstractTransHandler() {
            @Override
            public boolean isAsync() {
                return false;
            }

            @Override
            public boolean handle(TransContext context) {
                CreateOrderContext createOrderContext=(CreateOrderContext)context;
                createOrderContext.setOrderId(1L);
                createOrderContext.setDesc(" third handler!"+createOrderContext.getDesc());
                return true;
            }
        });
    }

    @Override
    protected TransConvert createConvert() {
        return new CreateOrderConvert();
    }
}
