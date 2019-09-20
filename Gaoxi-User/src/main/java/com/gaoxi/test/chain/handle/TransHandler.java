package com.gaoxi.test.chain.handle;

import com.gaoxi.test.chain.context.TransContext;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/20
 */
public interface TransHandler {
    /**
     * 是否采用异步方式执行
     * @return
     */
    boolean isAsync();

    /**
     * 执行具体业务
     * @param context
     * @return true 则继续执行下一个handler,否则结束Handler Chain的执行直接返回
     */
    boolean handle(TransContext context);
}
