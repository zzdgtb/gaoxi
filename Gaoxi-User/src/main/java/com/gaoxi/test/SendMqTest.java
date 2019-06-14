package com.gaoxi.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SendMqTest {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.33.12");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //channel.queueBind("amq.gen-l8oKfDXPGUTgIrwjcd7iiw", "IM_TOPIC", "ENV_AGENT_MEMBER_IM_MESSAGE");
        ChatMessageVo chatMessageVo = new ChatMessageVo();
        chatMessageVo.setData("test");
        System.out.println(getBytesFromObject(chatMessageVo));
        channel.basicPublish("IM_TOPIC", "ENV_AGENT_MEMBER_IM_MESSAGE", null, getBytesFromObject(chatMessageVo));
        //channel.queueDeclare(QUEUE_NAME, false, false, false, null);
       // String message = "Hello World!";
       // channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      //  System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }

    public  static byte[] getBytesFromObject(Serializable obj) throws Exception {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        return bo.toByteArray();
    }

}