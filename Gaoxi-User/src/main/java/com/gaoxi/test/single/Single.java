package com.gaoxi.test.single;

/**
 * @Description: 单例：饿汉式--浪费内存（不一定会用）
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class Single {
    private static Single single = new Single();

    private Single() {

    }

    public static Single getInstance() {
        return single;
    }
}
