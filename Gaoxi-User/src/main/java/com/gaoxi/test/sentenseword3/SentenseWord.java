package com.gaoxi.test.sentenseword3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class SentenseWord {

    private static Set<String> sentenseSet = new HashSet<String>();

    private static boolean scanContent(String content){
        for(String word:sentenseSet){
            if(content.contains(word)){
                System.out.println("拦截到敏感词:"+word);
                return false;
            }
        }
        System.out.println("不含敏感词");
        return true;
    }

    public static void main(String[] args)throws Exception{
        sentenseSet.add("你傻啊");
        sentenseSet.add("你傻不傻呀呀呀");
        sentenseSet.add("你傻不傻啊啊啊");
        sentenseSet.add("你傻不傻啊不傻");
        sentenseSet.add("煞笔");
        sentenseSet.add("智障");
        sentenseSet.add("sb");
        BufferedReader reader= new  BufferedReader(new FileReader("D:\\敏感词汇总.txt"));
        String tempString = null;
        int line = 1;
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            if((tempString.split("="))[0].length()<2){
                System.out.println((tempString.split("="))[0]);
            }else{
                sentenseSet.add((tempString.split("="))[0]);
            }

            // 显示行号
            System.out.println("line " + line + ": " + tempString);
            line++;
        }
        reader.close();
       /* for (Tree tree : treeSet) {
            scanTree(tree,0,"煞笔啊");
        }*/
        Long start = System.currentTimeMillis();
        scanContent("你&傻,不o 傻啊不傻你x傻啊啊 智，n障 ，bu啊煞,h笔a你傻,啊&");
        System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
    }
}
