package com.gaoxi.test.chain2.test;

import com.gaoxi.test.chain2.base.AbstractRequest;
import com.gaoxi.test.chain2.context.BaseContext;
import com.gaoxi.test.chain2.convert.BaseConvert;
import com.gaoxi.test.chain2.factory.AbsPipleLineFactory;
import com.gaoxi.test.chain2.handle.BaseHandle;
import com.gaoxi.test.chain2.node.PipleNode;
import com.gaoxi.test.chain2.pipleline.DefaultPipleLine;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/29
 */
public class CreateOrderPipelineFactory extends AbsPipleLineFactory {
    @Override
    protected void doBuild(DefaultPipleLine piple) {
        piple.addNode(new PipleNode(new BaseHandle() {
            @Override
            public void handle(BaseContext baseContext) {
                CreateOrderContext createOrderContext=(CreateOrderContext)baseContext;
                createOrderContext.setOrderId(1L);
                createOrderContext.setDesc(" first handler!"+createOrderContext.getDesc());
            }
        }).setAyc(false));
        piple.addNode(new PipleNode(new BaseHandle() {
            @Override
            public void handle(BaseContext baseContext) {
                CreateOrderContext createOrderContext=(CreateOrderContext)baseContext;
                createOrderContext.setOrderId(2L);
                createOrderContext.setDesc(" second handler!"+createOrderContext.getDesc());
            }
        }).setAyc(true));
        piple.addNode(new PipleNode(new BaseHandle() {
            @Override
            public void handle(BaseContext baseContext) {
                CreateOrderContext createOrderContext=(CreateOrderContext)baseContext;
                createOrderContext.setOrderId(3L);
                createOrderContext.setDesc(" third handler!"+createOrderContext.getDesc());
            }
        }).setAyc(true));
    }

    @Override
    protected BaseConvert createConvert(AbstractRequest absRequest) {
        return new CreateOrderConvert();
    }
}
