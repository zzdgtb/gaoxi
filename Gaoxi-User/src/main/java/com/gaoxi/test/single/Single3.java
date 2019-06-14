package com.gaoxi.test.single;


/**
 * @Description: 线程安全懒汉式：效率低
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class Single3 {
    private static Single3 single;

    private Single3() {

    }

    public static synchronized Single3 getInstance() {
        if (null == single) {
            single = new Single3();
        }
        return single;
    }
}
