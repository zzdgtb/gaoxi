package com.gaoxi.tmp;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public abstract class AbstractMicroServiceContext implements MicroServiceContext {
    public AbstractMicroServiceContext() {
    }

    public static String createContextKey(String key) {
        return key != null && key.startsWith("x-dtyunxi-context-") ? key : "x-dtyunxi-context-" + key;
    }
}