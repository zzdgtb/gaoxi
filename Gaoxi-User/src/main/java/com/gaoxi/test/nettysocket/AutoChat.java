package com.gaoxi.test.nettysocket;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.chatbot.model.v20171011.ChatRequest;
import com.aliyuncs.chatbot.model.v20171011.ChatResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 西门
 * @since 0.1.0
 */
public class AutoChat {
    private static DefaultProfile profile;
    private static IAcsClient client;

    static {
        profile = DefaultProfile.getProfile(
                Constants.REGION_ID,          // 地域ID
                Constants.ACCESS_KEY_ID,      // RAM账号的AccessKey ID
                Constants.ACCESS_KEY_SECRET); // RAM账号Access Key Secret
        client = new DefaultAcsClient(profile);
    }

    private ChatRequest request;

    public AutoChat() {
        inilizeRequest();
    }

    public void inilizeRequest() {
        request = new ChatRequest();
        request.setInstanceId(Constants.INSTANCEID);
        request.setConnectTimeout(5000); //设置连接超时为5000毫秒
        request.setReadTimeout(5000); //设置读超时为5000毫秒
    }

    public ChatResponse doChat(String content) {
        ChatResponse response = null;
        try {
            request.setSessionId("1");
            request.setUtterance(content);
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String getContentByType(String type, ChatResponse.Message m) {
        if (type.equals(ChatResponseTypeEnum.TEXT.type)) {
            return m.getText().getContent();
        }
        if (type.equals(ChatResponseTypeEnum.KNOWLEDGE.type)) {
            return m.getKnowledge().getContent();
        }
        /*if (type.equals(ChatResponseTypeEnum.RECOMMEND.type)) {
            StringBuffer content = new StringBuffer();
            for (ChatResponse.Message.Recommend r : m.getRecommends()) {
                content.append(r.getTitle());
            }
            return content.toString();
        }*/
        return null;
    }
    public List<String> getRecommondLists(String type, ChatResponse.Message m) {
        if (type.equals(ChatResponseTypeEnum.RECOMMEND.type)) {
            List<String> recommondLists = new ArrayList<String>();
            for (ChatResponse.Message.Recommend r : m.getRecommends()) {
                recommondLists.add(r.getTitle());
            }
            return recommondLists;
        }
        return null;
    }
}
