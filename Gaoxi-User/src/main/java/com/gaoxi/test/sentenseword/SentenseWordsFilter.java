package com.gaoxi.test.sentenseword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * root
 * /   |   \   \
 * 你    煞   智   傻
 * /       |     \    \
 * 傻       比     障    比
 * /  |
 * 啊  比
 * /
 * 啊
 */

/**
 * @Description: 敏感词过滤算法实现
 * @author: 西门
 * @Date: 2018/12/25
 * @version: 1.0.0
 */
public class SentenseWordsFilter {
    /**
     * 敏感词树集合，同一个词开头的敏感词在同一棵树下
     */
    private static Set<Tree> treeSet = new HashSet<Tree>();
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
     * @param sentenseWordsSet
     */
    public static void initSentenseWords(Set<String> sentenseWordsSet) {
        if (null == sentenseWordsSet || sentenseWordsSet.isEmpty()) {
            throw new IllegalArgumentException("sentenseWordsSet must not be null");
        }
        Iterator<String> irerator = sentenseWordsSet.iterator();
        while (irerator.hasNext()) {
            String currentWord = irerator.next();
            if (currentWord.length() < 2) {
                throw new IllegalArgumentException("sentenseWord's length con not be less than two");
            }
            Map<String, Node> currentMap = new ConcurrentHashMap<String, Node>(16);
            /*同一个字符开始的敏感词挂在同一棵树下*/
            Tree tree = getTreeByWord(String.valueOf(currentWord.charAt(0)));
            if (null == tree) {
                Node root = new Node(String.valueOf(currentWord.charAt(0)));
                tree = new Tree(root);
                treeSet.add(tree);
                nodeSet.add(root);
            }
            currentMap.put(String.valueOf(0), tree.getRoot());
            for (int i = 1; i < currentWord.length(); i++) {
                Node node = new Node(String.valueOf(currentWord.charAt(i)));
                setParentNode(node, currentMap.get(String.valueOf(i - 1)));
                currentMap.put(String.valueOf(i), node);
                nodeSet.add(node);
            }
        }
    }


    /**
     * 设置父节点
     *
     * @param child
     * @param parent
     */
    private static void setParentNode(Node child, Node parent) {
        child.setParent(parent);
        parent.getChildrenSet().add(child);
    }

    /**
     * 根据 词 从set中拿到节点
     *
     * @param word
     */
    /*private static Node getNodeByWord(String word) {
        for (Node node : nodeSet) {
            if (node.getWord().equals(word)) {
                return node;
            }
        }
        return null;
    }*/

    /**
     * 根据根节点获取树
     *
     * @param node
     * @return
     */
    private static Tree getTreeByRoot(Node node) {
        for (Tree tree : treeSet) {
            if (tree.getRoot().getWord().equals(node.getWord())) {
                return tree;
            }
        }
        return null;
    }

    /**
     * 根据根节点字符获取树
     *
     * @param rootword
     * @return
     */
    private static Tree getTreeByWord(String rootword) {
        for (Tree tree : treeSet) {
            if (tree.getRoot().getWord().equals(rootword)) {
                return tree;
            }
        }
        return null;
    }

    public static Node scanTree(Tree tree, int start, String content) {
        String scanword = String.valueOf(content.charAt(start));
        if (scanword.equals(tree.getRoot().getWord())) {
            return scanNode(tree.getRoot(), start + 1, content);
        }
        return null;
    }

    /**
     * 递归获取末节点
     * 校验 node是否含有word值等于content对应offset位上的字符值时的子节点
     * 如果有，offset右移，node赋值为对应的子节点，继续递归用此节点校验。
     * 递归结束条件：
     * 1：传入的node不再含有子节点，即content上的某一段字符都在敏感词树中能找到，
     * 且顺序刚好符合对应的父子关系，而且这一段字符对应了整个敏感词链（符合拦截条件）。
     * 此时返回该node（末节点）。
     * 2:node还含有子节点，但是文本已经结束了，即content上的某一段字符都在敏感词树中能找到，
     * 且顺序刚好符合对应的父子关系，但是这段字符只对应了这个敏感词链上的一部分（不符合拦截条件）
     * 此时返回null。
     * 3:node所有子节点的值不等于content 的offset位上对应的字符值,此时返回null
     *
     * @param node
     * @param offset
     * @param content
     * @return
     */
    public static Node scanNode(Node node, int offset, String content) {
        //末节点
        if (!node.hasChild()) {
            return node;
        }
        //尚未到末节点，但文本已结束
        if (offset > content.length() - 1) {
            return null;
        }
        String nextword = String.valueOf(content.charAt(offset));

        while (ignoreSet.contains(nextword)) {
            offset++;
            //忽略特殊字符后,尚未到末节点，但文本已结束
            if (offset > content.length() - 1) {
                return null;
            }
            nextword = String.valueOf(content.charAt(offset));
        }
        for (Node tmp : node.getChildrenSet()) {
            if (tmp.getWord().equals(nextword)) {
                offset++;
                //递归扫描子节点
                Node nd =scanNode(tmp, offset, content);
                if(nd==null){
                    //当前节点的下一个节点不包含下一个字符，撤销右移
                    offset--;
                    continue;
                }else{
                    return nd;
                }
            }
        }
        return null;
    }

    private static Node getEndNode(Tree tree, int start, String content) {
        return scanTree(tree, start, content);
    }

    private static boolean sentenseFilter(String content) {
        for (int i = 0; i < content.length(); i++) {
            String current = String.valueOf(content.charAt(i));
            //跳过忽略的字符
            if (ignoreSet.contains(current)) {
                continue;
            }
            Tree tree = getTreeByWord(current);
            if (tree == null) {
                continue;
            }
            Node endNode = getEndNode(tree, i, content);
            if (endNode == null) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            Node node = endNode;
            sb.append(endNode.getWord());
            while (node.hasParent()) {
                sb.insert(0, node.getParent().getWord());
                node = node.getParent();
            }
            System.out.println("文本被拦截，含有敏感词:" + sb.toString());
            return false;
        }
        System.out.println("不含敏感词");
        return true;
    }

    public static void main(String[] args) throws Exception{
        Set<String> sentenseWordsSet = new HashSet<String>();
        sentenseWordsSet.add("你傻啊");
        sentenseWordsSet.add("你傻不傻呀呀呀");
        sentenseWordsSet.add("你傻不傻啊啊啊");
        sentenseWordsSet.add("你傻不傻啊不傻");
        sentenseWordsSet.add("煞笔");
        sentenseWordsSet.add("智障");
        sentenseWordsSet.add("sb");
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
        sentenseFilter("你&傻,不o 傻啊不傻你x傻啊啊 智，n障 ，bu啊煞,h笔a你傻,啊&");
        System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
    }
}
