package com.gaoxi.test.single;

/**
 * @Description: 双重检查锁，比较全面
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class Single4 {
    private static Single4 single;

    private Single4(){

    }

    public static Single4 getInstance(){
        if(null==single){
            synchronized(Single4.class){
                if(null==single){
                    single=new Single4();
                }
            }
        }
        return single;
    }
}
