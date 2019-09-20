package com.gaoxi.test.chain.pipeline;

import com.gaoxi.test.chain.context.TransContext;
import com.gaoxi.test.chain.handle.TransHandler;
import com.gaoxi.test.chain.node.TransHandlerNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/20
 */
public class DefaultTransPipeline implements TransPipeline{

    private static final Logger logger = LoggerFactory.getLogger(DefaultTransPipeline.class);

    private TransHandlerNode tail;

    private TransHandlerNode head = new TransHandlerNode();

    private TransContext context = null;

    public DefaultTransPipeline(TransContext context) {
        setContext(context);
        tail = head;
    }

    @Override
    public void start() {
        try {
            head.getNext().exec(getContext());
        } catch (Exception ex) {
            logger.error("pipeline系统运行异常.", ex);
            throw ex;
        }
    }

    @Override
    public void shutdown() {

    }

    @Override
    public <T extends TransContext> T getContext() {
        return (T)context;
    }

    @Override
    public void addFirst(TransHandler... handlers) {
        TransHandlerNode pre = head.getNext();
        for (TransHandler handler : handlers) {
            if(handler == null) {
                continue;
            }
            TransHandlerNode node = new TransHandlerNode();
            node.setTransHandler(handler);
            node.setNext(pre);
            pre = node;
        }
        head.setNext(pre);
    }

    @Override
    public void addLast(TransHandler... handlers) {
        TransHandlerNode next = tail;
        for (TransHandler handler : handlers) {
            if(handler == null) {
                continue;
            }

            TransHandlerNode node = new TransHandlerNode();
            node.setTransHandler(handler);
            next.setNext(node);
            next = node;
        }

        tail = next;
    }
    public DefaultTransPipeline setContext(TransContext context) {
        this.context = context;
        return this;
    }
}
