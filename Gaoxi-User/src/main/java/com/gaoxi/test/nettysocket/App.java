package com.gaoxi.test.nettysocket;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);

        SocketIOServer server = new SocketIOServer(config);
        CharteventListener listner = new CharteventListener();
        ConnectListener connectListener = new MyConnectListener();
        listner.setServer(server);
        // chatevent为事件名称
        server.addEventListener("chatevent", ChatObject.class, listner);
        server.addConnectListener(connectListener);
        //启动服务
        server.start();
        Thread.sleep(Integer.MAX_VALUE);
        server.stop();
    }
}