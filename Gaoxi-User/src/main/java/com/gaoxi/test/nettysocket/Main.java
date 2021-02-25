package com.gaoxi.test.nettysocket;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.chatbot.model.v20171011.ChatRequest;
import com.aliyuncs.chatbot.model.v20171011.ChatResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author 西门
 * @since 0.1.0
 */
public class Main {
    public static void main(String[] args) {
        // 创建DefaultAcsClient实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-shanghai",          // 地域ID
                "*****************",      // RAM账号的AccessKey ID
                "******************************"); // RAM账号Access Key Secret
        IAcsClient client = new DefaultAcsClient(profile);

        // 创建API请求并设置参数
        ChatRequest request = new ChatRequest();
        request.setInstanceId("chatbot-cn-v0h0wr2ob000vc");
        //request.setKnowledgeId("1000192484");
        request.setUtterance("查客户信息");
        //request.setPageSize(10);
        request.setConnectTimeout(5000); //设置连接超时为5000毫秒
        request.setReadTimeout(5000); //设置读超时为5000毫秒
        // 发起请求并处理应答或异常
        ChatResponse response;
        try {
            response = client.getAcsResponse(request);
            System.out.println(response.getMessages());

            for (ChatResponse.Message m : response.getMessages()) {
                System.out.println(m.getText().getContent());
            }
           /* for (DescribeInstancesResponse.Instance instance:response.getInstances()) {
                System.out.println(instance.getPublicIpAddress());
            }*/
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
