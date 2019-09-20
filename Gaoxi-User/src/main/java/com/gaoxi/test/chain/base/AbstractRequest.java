package com.gaoxi.test.chain.base;

import java.io.Serializable;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/20
 */
public abstract class AbstractRequest implements Serializable {

    private static final long serialVersionUID = 1655740996017442916L;

    public AbstractRequest() {
    }

    public abstract void requestCheck();
}
