package com.gaoxi.test.lifecycle;

/**
 * @Description: 有些模块并不需要重写所有的方法，故加入此默认实现类
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class DefaultLifeCycleManager extends AbstractLifecycle {
    @Override
    protected void init0() throws LifeCycleException {

    }

    @Override
    protected void start0() throws LifeCycleException {

    }

    @Override
    protected void suspend0() throws LifeCycleException {

    }

    @Override
    protected void resume0() throws LifeCycleException {

    }

    @Override
    protected void destroy0() throws LifeCycleException {

    }
}
