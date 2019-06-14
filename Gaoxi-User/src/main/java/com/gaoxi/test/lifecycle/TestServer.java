package com.gaoxi.test.lifecycle;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class TestServer {
    public static void main(String[] args){
        SocketServer server = new SocketServer();
        server.addLifecycleListener(new DefaultLifeCycleListener());
        server.start();
    }
}
