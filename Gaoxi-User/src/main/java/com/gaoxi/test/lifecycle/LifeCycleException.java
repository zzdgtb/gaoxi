package com.gaoxi.test.lifecycle;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class LifeCycleException extends RuntimeException {
    /**
     * 异常信息
     */
    private String msg;

    public LifeCycleException(String msg){
        this.msg=msg;
    }
}
