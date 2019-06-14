package com.gaoxi.test.nettysocket;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.aliyuncs.chatbot.model.v20171011.ChatResponse;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 西门
 * @since 0.1.0
 */
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
        ChatObject from = data;
        System.out.println("server recived from " + from.getUserName() + ":" + from.getMessage());
        AutoChat chat = new AutoChat();
        ChatResponse response = chat.doChat(from.getMessage());
        StringBuilder content = new StringBuilder();
        List<String> recommondLists = new ArrayList<String>();
        if (null != response && null != response.getMessages()) {
            for (ChatResponse.Message m : response.getMessages()) {
                if(!(m.getType().equals(ChatResponseTypeEnum.RECOMMEND.type))){
                    String reply = chat.getContentByType(m.getType(), m);
                    if(reply!=null){
                        content.append(reply);
                    }
                }else{
                    List<String> replyLists = chat.getRecommondLists(m.getType(), m);
                    if(replyLists!=null&&replyLists.size()>0){
                        recommondLists.addAll(replyLists);
                    }
                }
            }
        }
        if(StringUtils.isBlank(content.toString())&&(null==recommondLists||recommondLists.size()==0)){
            ChatObject to = new ChatObject();
            to.setUserName("智能机器人");
            to.setMessage("找不到答案");
            client.sendEvent("chatevent", to);
        }else{
            ChatObject to = new ChatObject();
            MessageResponseVo responsevo = new MessageResponseVo();
            responsevo.setContent(content.toString());
            responsevo.setRecommondLists(recommondLists);
            to.setUserName("智能机器人");
            to.setMessage(JSON.json(responsevo));
            client.sendEvent("chatevent", to);
        }
        /*if (null != response && null != response.getMessages()) {
            for (ChatResponse.Message m : response.getMessages()) {
                String content = chat.getContentByType(m.getType(), m);
                ChatObject to = new ChatObject();
                to.setUserName("智能机器人");
                to.setMessage(content);
                client.sendEvent("chatevent", to);
            }
        }*/
    }
}