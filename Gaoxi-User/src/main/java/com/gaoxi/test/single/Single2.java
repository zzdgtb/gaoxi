package com.gaoxi.test.single;

/**
 * @Description: 懒汉式:线程不安全
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class Single2 {
    private static Single2 single;

    private Single2(){

    }

    public static Single2 getInstance(){
        if(null==single){
            single=new Single2();
        }
        return single;
    }
}
