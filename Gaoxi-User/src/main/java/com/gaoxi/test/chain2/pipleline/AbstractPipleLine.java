package com.gaoxi.test.chain2.pipleline;

import com.gaoxi.test.chain2.context.BaseContext;
import com.gaoxi.test.chain2.node.PipleNode;

import java.util.LinkedList;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/29
 */
public abstract class AbstractPipleLine implements BasePipleLine{

    protected LinkedList<PipleNode> nodeList = new LinkedList<>();

    protected BaseContext baseContext;

    public AbstractPipleLine(BaseContext baseContext){
        this.baseContext=baseContext;
    }

    public LinkedList<PipleNode> getNodeList() {
        return nodeList;
    }

    public AbstractPipleLine setNodeList(LinkedList<PipleNode> nodeList) {
        this.nodeList = nodeList;
        return this;
    }

    public BaseContext getBaseContext() {
        return baseContext;
    }

    public AbstractPipleLine setBaseContext(BaseContext baseContext) {
        this.baseContext = baseContext;
        return this;
    }
}
