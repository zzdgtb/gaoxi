
package com.gaoxi.test;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 聊天会话信息记录
 * @author beizai.yanxingxiao 
 * @date 2018年11月10日 下午3:51:33
 * @version 1.0.0
 *
 */
public class ChatMessageEo implements Serializable {
    /**
     * 用一句话描述这是什么
     */
    private static final long serialVersionUID = 1516599513976244493L;

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * uuid,全局唯一
     */
    private String uuid;
    
    /**
     * 消息渠道(1:公告;2:提醒;3:im信息)
     */
    private Integer channel;
    
    /**
     * 消息类别(1:图片;2:文件;3:语音;4:文本;5:机器人建议)
     */
    private Integer type;
    
    /**
     * data:消息内容
     */
    private String data;
    

    /**
     * sessionId:会话ID
     */
    private String sessionId;
    
    /**
     * 发送者id
     */
    private Long senderId;
    
    /**
     * sender:发送人姓名
     */
    private String sender;
    
    /**
     * 发送者类型 1客户 2客服 3机器人
     */
    private Integer senderType;

    /**
     * 接收者id
     */
    private Long targetId;
    
    /**
     * target:接收人姓名
     */
    private String target;
    
    /**
     * 接受者类型 1客户 2客服 3机器人
     */
    private Integer targetType;
    
    /**
     * 读取状态，0未读，1已读
     */
    private Integer status;
    
    /**
     * 租户id
     */
    private Long tenantId;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the channel
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * @param channel the channel to set
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the sessionId
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return the senderId
     */
    public Long getSenderId() {
        return senderId;
    }

    /**
     * @param senderId the senderId to set
     */
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the targetId
     */
    public Long getTargetId() {
        return targetId;
    }

    /**
     * @param targetId the targetId to set
     */
    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    /**
     * @return the target
     */
    public String getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the tenantId
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * @param tenantId the tenantId to set
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the senderType
     */
    public Integer getSenderType() {
        return senderType;
    }

    /**
     * @param senderType the senderType to set
     */
    public void setSenderType(Integer senderType) {
        this.senderType = senderType;
    }

    /**
     * @return the targetType
     */
    public Integer getTargetType() {
        return targetType;
    }

    /**
     * @param targetType the targetType to set
     */
    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }
}
