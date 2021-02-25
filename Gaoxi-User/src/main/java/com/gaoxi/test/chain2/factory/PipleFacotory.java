package com.gaoxi.test.chain2.factory;

import com.gaoxi.test.chain2.base.AbstractRequest;
import com.gaoxi.test.chain2.pipleline.BasePipleLine;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/29
 */
public interface PipleFacotory {
    /**
     *
     * @param absRequest
     * @return
     */
    BasePipleLine createPipleLine(AbstractRequest absRequest);
}
