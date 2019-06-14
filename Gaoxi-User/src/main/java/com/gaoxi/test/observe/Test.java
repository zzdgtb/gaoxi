package com.gaoxi.test.observe;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class Test {

    public static void main(String[] args){
        ObserverdUser user = new ObserverdUser();
        user.registyListener(new Listener("张三"));
        user.registyListener(new Listener("李四"));
        user.registyListener(new Listener("王五"));
        user.registyListener(new Listener("周六"));
        user.registyListener(new Listener("吴起"));
        user.doEvent(new Event("通知周六开会"));
        System.out.println("==========================");
        user.removeListener(new Listener("吴起"));
        user.doEvent(new Event("周日加班"));
    }
}
