package com.gaoxi.test.chain.factory;

import com.gaoxi.test.chain.base.AbstractRequest;
import com.gaoxi.test.chain.context.AbsTransContext;
import com.gaoxi.test.chain.context.TransContext;
import com.gaoxi.test.chain.convert.TransConvert;
import com.gaoxi.test.chain.pipeline.DefaultTransPipeline;
import com.gaoxi.test.chain.pipeline.TransPipeline;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/20
 */
public abstract class AbstranctTransPipelineFactory<T extends AbstractRequest> implements TransPipelineFactory<T> {

    @Override
    public TransPipeline build(T obj) {
        //创建转换器
        TransConvert convert = createConvert();
        //创建上下文
        TransContext context = createContext();
        //上朔
        AbsTransContext absCtx = (AbsTransContext) context;
        //set转换器
        absCtx.setConvert(convert);
        //上下文转换
        convert.request2TransContext(obj, context);
        //创建管道
        TransPipeline pipeline = createPipeline(context);
        //build管道
        doBuild(pipeline);
        //返回
        return pipeline;
    }

    protected abstract TransContext createContext();

    protected abstract void doBuild(TransPipeline pipeline);

    protected TransPipeline createPipeline(TransContext context) {
        return new DefaultTransPipeline(context);
    }

    protected abstract TransConvert createConvert();
}
