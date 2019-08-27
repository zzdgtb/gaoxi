package com.gaoxi.test.nettysocket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;

/**
 * @Description:
 * @author: 西门
 * @Date: 2019/7/3
 * @version: 1.0.0
 */
public class MyConnectListener implements ConnectListener {

    @Override
    public void onConnect(SocketIOClient socketIOClient) {
        System.out.println("============建立连接==============");
    }
}