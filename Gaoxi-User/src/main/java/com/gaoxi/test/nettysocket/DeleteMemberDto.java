package com.gaoxi.test.nettysocket;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.Serializable;
import java.util.List;

public class DeleteMemberDto implements Serializable {
    private static final long serialVersionUID = 8723130023958700710L;
    private String sessionId;
    private String userId;
    private Long memberId;
    private Long newMemberId;
    private Long tenantId;
    private StaffInfoOutMessageVo outMessageVo;
    private ChatMessageEo welcomeMessageEo;
    private List<Long> memberIdList;

    public DeleteMemberDto() {
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public List<Long> getMemberIdList() {
        return this.memberIdList;
    }

    public void setMemberIdList(List<Long> memberIdList) {
        this.memberIdList = memberIdList;
    }

    public Long getNewMemberId() {
        return this.newMemberId;
    }

    public void setNewMemberId(Long newMemberId) {
        this.newMemberId = newMemberId;
    }

    public StaffInfoOutMessageVo getOutMessageVo() {
        return this.outMessageVo;
    }

    public void setOutMessageVo(StaffInfoOutMessageVo outMessageVo) {
        this.outMessageVo = outMessageVo;
    }

    public ChatMessageEo getWelcomeMessageEo() {
        return this.welcomeMessageEo;
    }

    public void setWelcomeMessageEo(ChatMessageEo welcomeMessageEo) {
        this.welcomeMessageEo = welcomeMessageEo;
    }

    public Long getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}
