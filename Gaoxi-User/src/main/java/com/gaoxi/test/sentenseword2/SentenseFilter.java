package com.gaoxi.test.sentenseword2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class SentenseFilter {
    /**
     * 敏感词树
     */
    private static Tree tree = new Tree(new Node("root"));
    /**
     * 敏感词集合
     */
    private static Set<String> sentenseSet = new HashSet<String>();
    /**
     * 可以忽略的特殊字符
     */
    private static Set<String> ignoreSet = new HashSet<String>();

    private static Set<Node> nodeSet = new HashSet<Node>();

    static {
        ignoreSet.add("、");
        ignoreSet.add(" ");
        ignoreSet.add("@");
        ignoreSet.add("#");
        ignoreSet.add("&");
        ignoreSet.add(",");
        ignoreSet.add("，");
    }

    /**
     * 初始化敏感词树
     *
     * @param sentenseSet
     */
    public static void initSentenseWords(Set<String> sentenseSet) {
        if (null == sentenseSet || sentenseSet.size() == 0) {
            throw new IllegalArgumentException("sentense words can not be null");
        }
        for (String word : sentenseSet) {
            if (word.length() < 2) {
                throw new IllegalArgumentException("sentense words's length can not be less than two");
            }
            Map<String, Node> currentMap = new HashMap<String, Node>();
            Node first = tree.getRoot().getNoEndChildNodeByword(String.valueOf(word.charAt(0)));
            if (null == first) {
                first = new Node(String.valueOf(word.charAt(0)));
                nodeSet.add(first);
            }
            currentMap.put(String.valueOf(0), first);
            setParent(first, tree.getRoot());
            for (int i = 1; i < word.length(); i++) {
                Node pre = currentMap.get(String.valueOf(i - 1));
                Node now = pre.getNoEndChildNodeByword(String.valueOf(word.charAt(i)));
                if (null == now) {
                    now = new Node(String.valueOf(word.charAt(i)));
                    nodeSet.add(now);
                }
                setParent(now, pre);
                currentMap.put(String.valueOf(i), now);
                /*已到当前敏感词的最后一个字符*/
                if (i == word.length() - 1) {
                    now.setEndNode(true);
                }
            }
        }
    }

    /**
     * 敏感词校验
     * @param content
     * @return
     */
    public static boolean scanContent(String content){
        if(null==content){
            throw new IllegalArgumentException("content  can not be null");
        }
        if(content.length()<2){
            System.out.println("不含敏感词");
            return true;
        }
        for(int i=0;i<content.length()-1;i++){
            //当前字符不为敏感词的开头
            Node parent =tree.getRoot().getNoEndChildNodeByword(String.valueOf(content.charAt(i)));
            if(null==parent){
                continue;
            }
            Node endNode = getEndNodeByScan(parent,i+1,content);
            if(null==endNode){
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while(!endNode.getWord().equals("root")){
                sb.insert(0,endNode.getWord());
                endNode=endNode.getParent();
            }
            System.out.println("文本被拦截，含有敏感词:" + sb.toString());
            return false;
        }
        System.out.println("不含敏感词");
        return true;
    }

    /**
     * 获取子节点（算法思路：根据父节点和相邻的词就可以获取子节点,再根据子节点是否为末节点进行返回或递归）
     * @param parent
     * @param nextIndex
     * @param content
     * @return
     */
    public static Node getEndNodeByScan(Node parent,int nextIndex,String content){
        /*敏感词长度大于content匹配段长度*/
        if(nextIndex>content.length()-1){
            return null;
        }
        String nextword = String.valueOf(content.charAt(nextIndex));
        while (ignoreSet.contains(nextword)) {
            nextIndex++;
            //忽略特殊字符后,尚未到末节点，但文本已结束
            if (nextIndex > content.length() - 1) {
                return null;
            }
            nextword = String.valueOf(content.charAt(nextIndex));
        }
        Node end = parent.getEndChildNodeByword(nextword);
        if(null!=end){
           return end;
        }
        Node noEnd = parent.getNoEndChildNodeByword(nextword);

        if(null==noEnd){
            return null;
        }
        nextIndex++;
        return getEndNodeByScan(noEnd,nextIndex,content);
    }

    /**
     * 设置父节点
     *
     * @param child
     * @param parent
     */
    private static void setParent(Node child, Node parent) {
        child.setParent(parent);
        parent.getChildSet().add(child);
    }

    public static void main(String[] args)throws Exception{
        Set<String> sentenseWordsSet = new HashSet<String>();
        sentenseWordsSet.add("你傻啊");
        sentenseWordsSet.add("你傻不傻呀呀呀");
        sentenseWordsSet.add("你傻不傻啊啊啊");
        sentenseWordsSet.add("你傻不傻啊不傻");
        sentenseWordsSet.add("煞笔");
        sentenseWordsSet.add("智障");
        sentenseWordsSet.add("sb");
        //InputStream in = new FileInputStream("D:\\敏感词汇总.txt");
       // FileReader read = new FileReader("D:\\敏感词汇总.txt");
        BufferedReader reader= new  BufferedReader(new FileReader("D:\\敏感词汇总.txt"));
        String tempString = null;
        int line = 1;
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            if((tempString.split("="))[0].length()<2){
                System.out.println((tempString.split("="))[0]);
            }else{
                sentenseWordsSet.add((tempString.split("="))[0]);
            }

            // 显示行号
            System.out.println("line " + line + ": " + tempString);
            line++;
        }
        reader.close();

       /* for (Tree tree : treeSet) {
            scanTree(tree,0,"煞笔啊");
        }*/
        initSentenseWords(sentenseWordsSet);
        System.out.println(nodeSet.size());
        Long start = System.currentTimeMillis();
        scanContent("你&傻,不o 傻啊不傻你x傻啊啊 智，n障 ，bu啊煞,h笔a你傻,啊&");
        System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
    }
}
