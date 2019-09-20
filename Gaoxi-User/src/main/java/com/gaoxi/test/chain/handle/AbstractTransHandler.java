package com.gaoxi.test.chain.handle;

import com.gaoxi.test.chain.callback.TransCallBack;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/20
 */
public abstract class AbstractTransHandler implements TransHandler {

    private static final String DEFAULT = "default";

    public TransCallBack getTransCallback(){return null;}
}
