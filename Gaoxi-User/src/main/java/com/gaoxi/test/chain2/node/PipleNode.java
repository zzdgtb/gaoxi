package com.gaoxi.test.chain2.node;

import com.gaoxi.test.chain2.context.BaseContext;
import com.gaoxi.test.chain2.handle.BaseHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/29
 */
public class PipleNode implements BaseNode {
    private static final Logger logger = LoggerFactory.getLogger(PipleNode.class);
    protected BaseHandle handle;
    /**
     * 是否异步执行，默认false
     */
    protected boolean isAyc = false;

    public PipleNode(BaseHandle handle){
        this.handle = handle;
    }

    @Override
    public void process(BaseContext baseContext) {
        synchronized (baseContext){
            logger.info("当前执行的线程:{}",Thread.currentThread().getName());
            this.handle.handle(baseContext);
        }
    }

    public BaseHandle getHandle() {
        return handle;
    }

    public PipleNode setHandle(BaseHandle handle) {
        this.handle = handle;
        return this;
    }

    public boolean isAyc() {
        return isAyc;
    }

    public PipleNode setAyc(boolean ayc) {
        isAyc = ayc;
        return this;
    }
}
