package com.gaoxi.test.chain2.handle;

import com.gaoxi.test.chain2.context.BaseContext;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/29
 */
public interface BaseHandle {
    /**
     * 执行
     * @param baseContext
     */
    void handle(BaseContext baseContext);

}
