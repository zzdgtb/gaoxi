package com.gaoxi.test.lifecycle;

import java.util.List;
import java.util.Vector;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public abstract class AbstractLifecycle implements ILifeCycle {
    /**
     * 监听者,全局管理的实例变量，考虑多线程
     */
    private List<ILifeCycleListener> listeners = new Vector<ILifeCycleListener>();
    /**
     * 当前生命周期状态
     */
    private LifeCycleStatus status = LifeCycleStatus.NEW;

    @Override
    public final synchronized void init() {
        if (status != LifeCycleStatus.NEW) {
            return;
        }
        System.out.println("开始初始化。。。");
        setStateAndFireEvent(LifeCycleStatus.INITIALIZING);
        try {
            init0();
        } catch (Throwable t) {
            setStateAndFireEvent(LifeCycleStatus.FAILED);
            if (t instanceof LifeCycleException) {
                throw (LifeCycleException) t;
            } else {
                throw new LifeCycleException(String.format("failed to initialize %s,error mssage: %s", toString(), t.getMessage()));
            }
        }
        setStateAndFireEvent(LifeCycleStatus.INITIALIZED);
        System.out.println("初始化成功=====");
    }

    protected abstract void init0() throws LifeCycleException;


    @Override
    public final synchronized void start() {
        if (status == LifeCycleStatus.NEW) {
            init();
        }
        if (status != LifeCycleStatus.INITIALIZED) {
            return;
        }
        System.out.println("开始启动。。。");
        setStateAndFireEvent(LifeCycleStatus.STARTING);
        try {
            start0();
        } catch (Throwable t) {
            setStateAndFireEvent(LifeCycleStatus.FAILED);
            if (t instanceof LifeCycleException) {
                throw (LifeCycleException) t;
            } else {
                throw new LifeCycleException(String.format("failed to start %s,error mssage: %s", toString(), t.getMessage()));
            }
        }
        setStateAndFireEvent(LifeCycleStatus.STARTED);
        System.out.println("启动成功=====");
    }

    protected abstract void start0() throws LifeCycleException;

    @Override
    public void suspend() {
        if (status != LifeCycleStatus.STARTED) {
            return;
        }
        setStateAndFireEvent(LifeCycleStatus.SUSPENDING);
        try {
            suspend0();
        } catch (Throwable t) {
            setStateAndFireEvent(LifeCycleStatus.FAILED);
            if (t instanceof LifeCycleException) {
                throw (LifeCycleException) t;
            } else {
                throw new LifeCycleException(String.format("failed to suspend %s,error mssage: %s", toString(), t.getMessage()));
            }
        }
        setStateAndFireEvent(LifeCycleStatus.SUSPENDED);
    }

    protected abstract void suspend0() throws LifeCycleException;

    @Override
    public void resume() {
        if (status != LifeCycleStatus.SUSPENDED) {
            return;
        }
        setStateAndFireEvent(LifeCycleStatus.RESUMING);
        try {
            resume0();
        } catch (Throwable t) {
            setStateAndFireEvent(LifeCycleStatus.FAILED);
            if (t instanceof LifeCycleException) {
                throw (LifeCycleException) t;
            } else {
                throw new LifeCycleException(String.format("failed to resume %s,error mssage: %s", toString(), t.getMessage()));
            }
        }
        setStateAndFireEvent(LifeCycleStatus.RESUMED);
    }

    protected abstract void resume0() throws LifeCycleException;

    @Override
    public void destroy() {
        if (status == LifeCycleStatus.DESTROYED || status == LifeCycleStatus.DESTROYING) {
            return;
        }
        setStateAndFireEvent(LifeCycleStatus.DESTROYING);
        try {
            destroy0();
        } catch (Throwable t) {
            setStateAndFireEvent(LifeCycleStatus.FAILED);
            if (t instanceof LifeCycleException) {
                throw (LifeCycleException) t;
            } else {
                throw new LifeCycleException(String.format("failed to destroy %s,error mssage: %s", toString(), t.getMessage()));
            }
        }
        setStateAndFireEvent(LifeCycleStatus.DESTROYED);
    }

    protected abstract void destroy0() throws LifeCycleException;

    @Override
    public void addLifecycleListener(ILifeCycleListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeLifevycleListener(ILifeCycleListener listener) {
        listeners.remove(listener);
    }

    protected synchronized void setStateAndFireEvent(LifeCycleStatus status) {
        this.status=status;
        noticeListener(new LifeCycleEvent(this.status));
    }

    /**
     * 通知观察者
     * @param evt
     */
    private void noticeListener(LifeCycleEvent evt){
        for(ILifeCycleListener listener : listeners){
            listener.listenLifeCycleEvent(evt);
        }
    }
    public synchronized LifeCycleStatus getStatus() {
        return status;
    }

    public synchronized AbstractLifecycle setStatus(LifeCycleStatus status) {
        this.status = status;
        return this;
    }
}
