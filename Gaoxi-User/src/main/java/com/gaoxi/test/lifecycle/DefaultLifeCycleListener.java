package com.gaoxi.test.lifecycle;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class DefaultLifeCycleListener implements ILifeCycleListener {
    @Override
    public void listenLifeCycleEvent(LifeCycleEvent evt) {
        System.out.println("当前状态:"+evt.getStatus());
    }
}
