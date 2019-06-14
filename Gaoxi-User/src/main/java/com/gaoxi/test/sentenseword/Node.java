package com.gaoxi.test.sentenseword;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 树形结构的实现--节点
 * @author: 西门
 * @Date: 2018/12/25
 * @version: 1.0.0
 */
public class Node {
    /**
     * 节点特征
     */
    private String word;
    /**
     * 父节点
     */
    private Node parent;
    /**
     * 子节点
     */
    private Set<Node> childrenSet=new HashSet<Node>();
    /**
     * 深度
     */
    private Integer deep;

    public Node(String word){
        /**
         * 树的初始高度设为1
         */
        this.deep=1;
        this.word=word;
    }

    public String getWord() {
        return word;
    }

    public Node setWord(String word) {
        this.word = word;
        return this;
    }

    public Node getParent() {
        return parent;
    }

    public Node setParent(Node parent) {
        this.parent = parent;
        return this;
    }

    public Set<Node> getChildrenSet() {
        return childrenSet;
    }

    public Node setChildrenSet(Set<Node> childrenSet) {
        this.childrenSet = childrenSet;
        return this;
    }

    public Integer getDeep() {
        return deep;
    }

    public Node setDeep(Integer deep) {
        this.deep = deep;
        return this;
    }
    public boolean hasChild(){
        return this.childrenSet.size()>0?true:false;
    }

    public boolean hasParent(){
        return this.parent==null?false:true;
    }
   /* @Override
    public boolean equals(Object o) {
        if (this == o){return true;}
        if (o == null || getClass() != o.getClass()){return false;}
        Node node = (Node) o;
        return Objects.equal(word, node.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }*/

   /* *//**
     * 根据 词 从set中拿到节点
     *
     * @param word
     *//*
    private  Node getNodeByWord(String word) {
        for (Node node : this.childrenSet) {
            if (node.getWord().equals(word)) {
                return node;
            }
        }
        return null;
    }*/
    public Set<Node> getChildNodeSetByword(String word){
        Set<Node> set = new HashSet<Node>();
        for(Node node : this.childrenSet){
            if (node.getWord().equals(word)) {
                set.add(node);
            }
        }
        return set;
    }
}
