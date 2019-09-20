package com.gaoxi.test.chain.node;

import com.gaoxi.test.chain.callback.TransCallBack;
import com.gaoxi.test.chain.context.TransContext;
import com.gaoxi.test.chain.handle.AbstractTransHandler;
import com.gaoxi.test.chain.handle.TransHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 西门
 * @version 0.1.0
 * @description 流程处理节点--每个节点对应一个handler
 * @date 2019/9/20
 */
public class TransHandlerNode {

    private static final Logger logger = LoggerFactory.getLogger(TransHandlerNode.class);
    /**
     * handler
     */
    private TransHandler transHandler;
    /**
     * 下一节点
     */
    private TransHandlerNode next;

    public void exec(TransContext context){
        logger.info("当前执行的线程:{}",Thread.currentThread().getName());
        boolean success = transHandler.handle(context);
        AbstractTransHandler abshandler = (AbstractTransHandler)transHandler;
        execCallbacks(abshandler.getTransCallback(), context, null);
        if(success){
            if(null!=next){
                if(next.transHandler.isAsync()){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            next.exec(context);
                        }
                    }).start();
                }else{
                    next.exec(context);
                }
            }
        }
    }

    private void execCallbacks(TransCallBack callback, TransContext context, Throwable ex) {
        try {
            if (ex == null&&callback!=null) {
                callback.onDone(context);
            }
        } catch (Exception e) {
            logger.warn("Pipeline回调处理异常.", e);
            //TODO 异常处理
        }
    }

    public TransHandler getTransHandler() {
        return transHandler;
    }

    public TransHandlerNode setTransHandler(TransHandler transHandler) {
        this.transHandler = transHandler;
        return this;
    }

    public TransHandlerNode getNext() {
        return next;
    }

    public TransHandlerNode setNext(TransHandlerNode next) {
        this.next = next;
        return this;
    }
}
