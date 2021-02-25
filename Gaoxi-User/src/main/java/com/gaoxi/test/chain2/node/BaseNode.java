package com.gaoxi.test.chain2.node;

import com.gaoxi.test.chain2.context.BaseContext;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/29
 */
public interface BaseNode {
    /**
     *
     * @param baseContext
     */
    void process(BaseContext baseContext);

}
