package com.gaoxi.test.lifecycle;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public interface LifeCycle {
    void init();

    void start();

    void suspend();

    void resume();

    void destroy();

    void addLifecycleListener(ILifeCycleListener listener);

    void removeLifevycleListener(ILifeCycleListener listener);
}
