package com.gaoxi.configcenter;

import com.gaoxi.test.lifecycle.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Vector;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public abstract class AbstractConfigService implements IConfigService, ILifeCycle {

    private Logger logger = LoggerFactory.getLogger(AbstractConfigService.class);

    private List<ILifeCycleListener> listeners = new Vector<ILifeCycleListener>();

    private LifeCycleStatus status = LifeCycleStatus.NEW;

    @Override
    public Object getConfig(String groupId, String dataId) {
        if (status == LifeCycleStatus.NEW) {
            init();
        }
        if (status != LifeCycleStatus.INITIALIZED) {
            return null;
        }
        logger.info("开始获取配置=======================");
        Object obj = null;
        try {
            obj = get0(groupId, dataId);
        } catch (Exception e) {
            if (e instanceof LifeCycleException) {
                throw e;
            } else {
                throw new LifeCycleException(String.format("获取配置失败:%s", e.getMessage()));
            }
        }
        logger.info("获取配置完成=======================");
        return obj;
    }

    protected abstract Object get0(String groupId, String dataId);

    @Override
    public void addConfig(String groupId, String dataId, String content) {
        if (status == LifeCycleStatus.NEW) {
            init();
        }
        if (status != LifeCycleStatus.INITIALIZED) {
            return;
        }
        logger.info("开始添加配置=======================");
        Object obj = null;
        try {
            add0(groupId, dataId, content);
        } catch (Exception e) {
            if (e instanceof LifeCycleException) {
                throw e;
            } else {
                throw new LifeCycleException(String.format("添加配置失败:%s", e.getMessage()));
            }
        }
        logger.info("添加配置完成=======================");
    }

    protected abstract void add0(String groupId, String dataId, String content);

    @Override
    public synchronized void init() {
        if (status != LifeCycleStatus.NEW) {
            return;
        }
        logger.info("初始化开始=======================");
        setAndNoticStatus(LifeCycleStatus.INITIALIZING);
        try {
            init0();
        } catch (Exception e) {
            if (e instanceof LifeCycleException) {
                throw e;
            } else {
                throw new LifeCycleException(String.format("初始化失败:%s", e.getMessage()));
            }
        }
        setAndNoticStatus(LifeCycleStatus.INITIALIZED);
        logger.info("初始化完成=======================");
    }

    protected abstract void init0();

    private void setAndNoticStatus(LifeCycleStatus status) {
        this.status = status;
        noticeListener();
    }

    @Override
    public void addLifecycleListener(ILifeCycleListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeLifevycleListener(ILifeCycleListener listener) {
        listeners.remove(listener);
    }

    private void noticeListener() {
        for (ILifeCycleListener listener : listeners) {
            listener.listenLifeCycleEvent(new LifeCycleEvent(status));
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void suspend() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {

    }
}
