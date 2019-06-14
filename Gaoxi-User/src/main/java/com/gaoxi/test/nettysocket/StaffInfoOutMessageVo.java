package com.gaoxi.test.nettysocket;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.Serializable;

public class StaffInfoOutMessageVo implements Serializable {
    private static final long serialVersionUID = -689125959958615217L;
    private String successTips;
    private String welcomeTips;
    private String createTime;
    private String imgUrl;
    private String username;
    private String userId;
    private String sessionId;
    private String tips;

    public StaffInfoOutMessageVo() {
    }

    public String getSuccessTips() {
        return this.successTips;
    }

    public void setSuccessTips(String successTips) {
        this.successTips = successTips;
    }

    public String getWelcomeTips() {
        return this.welcomeTips;
    }

    public void setWelcomeTips(String welcomeTips) {
        this.welcomeTips = welcomeTips;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTips() {
        return this.tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
