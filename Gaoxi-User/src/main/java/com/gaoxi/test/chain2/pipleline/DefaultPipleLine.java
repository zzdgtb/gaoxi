package com.gaoxi.test.chain2.pipleline;

import com.gaoxi.test.chain2.context.BaseContext;
import com.gaoxi.test.chain2.node.PipleNode;
import org.springframework.util.CollectionUtils;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/29
 */
public class DefaultPipleLine extends AbstractPipleLine {

    public DefaultPipleLine(BaseContext baseContext) {
        super(baseContext);
    }
    @Override
    public void start() {
        while (!CollectionUtils.isEmpty(this.nodeList)) {
            PipleNode node = nodeList.pollFirst();
            if (node.isAyc()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        node.process(baseContext);
                    }
                }).start();

            } else {
                node.process(baseContext);
            }
        }
    }

    @Override
    public BaseContext getContext() {
        return this.baseContext;
    }

    @Override
    public void addNode(PipleNode node) {
        this.nodeList.addLast(node);
    }

}
