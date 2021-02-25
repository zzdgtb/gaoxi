package com.gaoxi.test.chain2.pipleline;

import com.gaoxi.test.chain2.context.BaseContext;
import com.gaoxi.test.chain2.node.PipleNode;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/29
 */
public interface BasePipleLine {
    /**
     *
     */
    void start();

    /**
     * 获取上下文
     * @return
     */
    BaseContext getContext();

    /**
     *添加节点
     * @param node
     */
    void addNode(PipleNode node);

}
