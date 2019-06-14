package com.gaoxi.test.factory;

import com.gaoxi.test.lifecycle.*;

import java.util.List;
import java.util.Vector;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public abstract class AbstractCacheService implements ICache, ILifeCycle {
    /**
     * 引入生命周期管理
     */
    private List<ILifeCycleListener> listeners = new Vector<ILifeCycleListener>();

    private LifeCycleStatus status = LifeCycleStatus.NEW;

    @Override
    public final synchronized void set(String key, Object val) {
        if (status == LifeCycleStatus.NEW) {
            init();
        }
        if (status == LifeCycleStatus.DESTROYED || status == LifeCycleStatus.DESTROYING) {
            System.out.println("服务已关闭,无法访问缓存");
            return;
        }
        if (status == LifeCycleStatus.INITIALIZING) {
            System.out.println("服务未完成初始化,无法访问缓存");
            return;
        }
        set0(key, val);
    }

    protected abstract void set0(String key, Object val);

    @Override
    public final synchronized Object get(String key) {
        if (status == LifeCycleStatus.NEW) {
            init();
        }
        if (status == LifeCycleStatus.DESTROYED || status == LifeCycleStatus.DESTROYING) {
            System.out.println("服务已关闭,无法访问缓存");
            return null;
        }
        if (status == LifeCycleStatus.INITIALIZING) {
            System.out.println("服务未完成初始化,无法访问缓存");
            return null;
        }
        return get0(key);
    }

    @Override
    public synchronized void init() {
        if (status != LifeCycleStatus.NEW) {
            return;
        }
        System.out.println("开始初始化。。。");
        setAndNoticeListener(LifeCycleStatus.INITIALIZING);
        try {
            init0();
        } catch (Throwable t) {
            setAndNoticeListener(LifeCycleStatus.FAILED);
            if (t instanceof LifeCycleException) {
                throw (LifeCycleException) t;
            } else {
                throw new LifeCycleException(String.format("failed to initialize %s,error mssage: %s", toString(), t.getMessage()));
            }
        }
        setAndNoticeListener(LifeCycleStatus.INITIALIZED);
        System.out.println("初始化成功=====");
    }

    @Override
    public synchronized void destroy() {
        if (status == LifeCycleStatus.DESTROYED || status == LifeCycleStatus.DESTROYING) {
            return;
        }
        setAndNoticeListener(LifeCycleStatus.DESTROYING);
        try {
            destroy0();
        } catch (Throwable t) {
            setAndNoticeListener(LifeCycleStatus.FAILED);
            if (t instanceof LifeCycleException) {
                throw (LifeCycleException) t;
            } else {
                throw new LifeCycleException(String.format("failed to destroy %s,error mssage: %s", toString(), t.getMessage()));
            }
        }
        setAndNoticeListener(LifeCycleStatus.DESTROYED);
    }
    @Override
    public void addLifecycleListener(ILifeCycleListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeLifevycleListener(ILifeCycleListener listener) {
        listeners.remove(listener);
    }
    public void noticeListener() {
        for (ILifeCycleListener listener : listeners) {
            listener.listenLifeCycleEvent(new LifeCycleEvent(status));
        }
    }
    public synchronized void setAndNoticeListener(LifeCycleStatus status) {
        this.status = status;
        noticeListener();
    }
    protected abstract Object get0(String key);
    protected abstract void init0();
    protected abstract void destroy0();
    @Override
    public void start() { }
    @Override
    public void suspend() { }
    @Override
    public void resume() { }
}
