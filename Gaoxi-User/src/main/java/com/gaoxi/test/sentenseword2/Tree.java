package com.gaoxi.test.sentenseword2;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class Tree {
    /**
     * 根节点
     */
    private Node root;

    public  Tree(Node root){
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Tree setRoot(Node root) {
        this.root = root;
        return this;
    }
}
