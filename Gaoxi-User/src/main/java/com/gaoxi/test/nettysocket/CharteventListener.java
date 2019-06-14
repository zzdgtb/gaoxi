package com.gaoxi.test.nettysocket;

import com.aliyuncs.chatbot.model.v20171011.ChatRequest;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

public class CharteventListener implements DataListener<ChatObject> {

    SocketIOServer server;

    public void setServer(SocketIOServer server) {
        this.server = server;
    }
    @Override
    public void onData(SocketIOClient client, ChatObject data,
                       AckRequest ackSender) throws Exception {
        // chatevent为 事件的名称， data为发送的内容
        this.server.getBroadcastOperations().sendEvent("chatevent", data);
        ChatObject from=(ChatObject)data;
        System.out.println("server recived from "+from.getUserName()+":"+from.getMessage());
        ChatObject to = new ChatObject();
        to.setUserName("server");
        to.setMessage("hello  "+from.getMessage()+"!");
        Thread.sleep(5000);
        client.sendEvent("chatevent",to);
        ChatRequest request = new ChatRequest();

    }
}