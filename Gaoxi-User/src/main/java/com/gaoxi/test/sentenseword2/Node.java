package com.gaoxi.test.sentenseword2;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 节点
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class Node {
    /**
     * 表征节点的特征：此处为字符
     */
    private String word;
    /**
     * 父节点
     */
    private Node parent;
    /**
     * 子节点：如果重写了equals则表示子节点不重复，否则，支持子节点重复的结构
     */
    private Set<Node> childSet=new HashSet<Node>();

    private boolean isEndNode=false;

    public Node(String word) {
        this.word = word;
    }

    /**
     * 是否有子节点
     * @return
     */
    public boolean haseChild(){
        return childSet.size()>0;
    }

    /**
     * 是否有父节点
     * @return
     */
    public boolean hashParent(){
        return parent!=null;
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

    public Set<Node> getChildSet() {
        return childSet;
    }

    public Node setChildSet(Set<Node> childSet) {
        this.childSet = childSet;
        return this;
    }

    public boolean isEndNode() {
        return isEndNode;
    }

    public Node setEndNode(boolean endNode) {
        isEndNode = endNode;
        return this;
    }

    /**
     * 根据字符获取不为末节点的子节点(数据结构的特点决定了不存在大于1个，子节点为末节点的而且为相同词的节点)
     * @param word
     * @return
     */
    public Node getNoEndChildNodeByword(String word){
        for(Node node : this.childSet){
            //子节点为末节点时直接跳过
            if(node.isEndNode){
                continue;
            }
            if(node.word.equals(word)){
                return node;
            }
        }
        return null;
    }

    /**
     * 根据字符获取末节点的子节点
     * @return
     */
    public Node getEndChildNodeByword(String word){
        for(Node node : this.childSet){
            if(node.isEndNode&&node.word.equals(word)){
                return node;
            }
        }
        return null;
    }

    public Set<Node> getNodeByword(String nextword) {
        Set<Node> set = new HashSet<Node>();
        for(Node node : this.childSet){
            if(node.word.equals(word)){
                set.add(node);
            }
        }
        return set;
    }
    /*@Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        Node node = (Node) o;
        return Objects.equal(word, node.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }*/
}
