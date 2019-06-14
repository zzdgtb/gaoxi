package com.gaoxi.test.sentenseword;

import com.google.common.base.Objects;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/26
 * @version: 1.0.0
 */
public class Tree {
    /**
     * 根节点
     */
    private Node root;

    public Tree(Node root){
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Tree setRoot(Node root) {
        this.root = root;
        return this;
    }

    /**
     * 以根节点来区分树
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()){return false;}
        Tree tree = (Tree) o;
        return Objects.equal(root, tree.root);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(root);
    }

}
