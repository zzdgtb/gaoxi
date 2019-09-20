package com.gaoxi.test.chain.pipeline;

import com.gaoxi.test.chain.context.TransContext;
import com.gaoxi.test.chain.handle.TransHandler;

/**
 * @author 西门
 * @version 0.1.0
 * @description 流出链
 * @date 2019/9/20
 */
public interface TransPipeline {

    /**
     * 启动流程.<br/>
     *
     */
    void start();

    /**
     * 终止流程.<br/>
     *
     */
    void shutdown();
    /**
     * 用于获取返回值<br/>
     *
     * @return
     */
    <T extends TransContext> T getContext();

    /**
     *头部添加handler
     * @param handlers
     */
    void addFirst(TransHandler... handlers);

    /**
     *尾部添加handler
     * @param handlers
     */
    void addLast(TransHandler... handlers);
}
