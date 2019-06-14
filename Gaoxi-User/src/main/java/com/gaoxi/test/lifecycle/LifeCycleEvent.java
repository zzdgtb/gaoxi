package com.gaoxi.test.lifecycle;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class LifeCycleEvent {

    private LifeCycleStatus status;

    public LifeCycleEvent(LifeCycleStatus status) {
        this.status = status;
    }
    public LifeCycleEvent() {
    }
    public LifeCycleStatus getStatus() {
        return status;
    }

    public LifeCycleEvent setStatus(LifeCycleStatus status) {
        this.status = status;
        return this;
    }
}
