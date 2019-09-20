package com.gaoxi.test.chain.convert;

import com.gaoxi.test.chain.base.AbstractRequest;
import com.gaoxi.test.chain.base.AbstractResponse;
import com.gaoxi.test.chain.context.TransContext;

/**
 * @author 西门
 * @version 0.1.0
 * @description 类转换
 * @date 2019/9/20
 */
public interface TransConvert {
    /**
     * 请求转上下文
     * @param req
     * @return
     */
    TransContext request2TransContext(AbstractRequest req, TransContext context);

    /**
     * 上下文转应答
     * @param context
     * @return
     */
    AbstractResponse context2Response(TransContext context);
}
