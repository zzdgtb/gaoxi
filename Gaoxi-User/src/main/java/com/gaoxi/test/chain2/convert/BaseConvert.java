package com.gaoxi.test.chain2.convert;

import com.gaoxi.test.chain2.base.AbstractRequest;
import com.gaoxi.test.chain2.base.AbstractResponse;
import com.gaoxi.test.chain2.context.BaseContext;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/29
 */
public interface BaseConvert {
    /**
     * request转换为上下文
     * @param abstractRequest
     * @return
     */
    BaseContext request2Context(AbstractRequest abstractRequest);

    /**
     * 上下文转换为response
     * @param baseContext
     * @return
     */
    AbstractResponse context2Response(BaseContext baseContext);
}
