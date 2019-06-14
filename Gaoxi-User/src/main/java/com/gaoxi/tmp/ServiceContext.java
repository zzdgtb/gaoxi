package com.gaoxi.tmp;

import com.gaoxi.Test.StringUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class ServiceContext implements ServiceConstants {
    private MicroServiceContext microServiceContext;
    private static final ThreadLocal<ServiceContext> LOCAL = new ThreadLocal<ServiceContext>() {
        protected ServiceContext initialValue() {
            return new ServiceContext();
        }
    };
    private final Map<String, Object> mapValue;

    private ServiceContext() {
        this.microServiceContext = null;
        this.mapValue = new ConcurrentHashMap();
    }

    public static ServiceContext getContext() {
        return (ServiceContext)LOCAL.get();
    }

    public static void removeContext() {
        LOCAL.remove();
    }

    private MicroServiceContext getMicroServiceContext() {
        if (this.microServiceContext == null) {
            String className = "com.dtyunxi.yes.rpc.SpringCloudMicroServiceContext";
            if (DeployEnv.isEdasHsf()) {
                className = "com.dtyunxi.yes.rpc.EdasMicroServiceContext";
            }

            try {
                this.microServiceContext = (MicroServiceContext)Class.forName(className).newInstance();
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        }

        return this.microServiceContext;
    }

    public void removeAttachmentContext() {
        if (this.microServiceContext != null) {
            this.microServiceContext.removeContext();
        }

    }

    public void set(String key, Object value) {
        if (value == null) {
            this.mapValue.remove(key);
        } else {
            this.mapValue.put(key, value);
        }

    }

    public void remove(String key) {
        this.mapValue.remove(key);
    }

    public Object get(String key) {
        return this.mapValue.get(key);
    }

    public Map<String, Object> getKeys() {
        return this.mapValue;
    }

    public void setAttachment(String key, String attachment) {
        this.set(key, attachment);
        this.getMicroServiceContext().setAttachment(key, attachment);
    }

    public String getAttachment(String key) {
        String value = (String)this.get(key);
        if (value == null) {
            value = this.getMicroServiceContext().getAttachment(key);
        }

        return value;
    }

    public void removeAttachment(String key) {
        this.remove(key);
        this.getMicroServiceContext().removeAttachment(key);
    }

    public Map<String, String> getAttachments() {
        return this.getMicroServiceContext().getAttachments();
    }

    public String getAppId() {
        String value = (String)this.get("dtyunxi.appId");
        if (value == null) {
            value = this.getMicroServiceContext().getAttachment("dtyunxi.appId");
        }

        return value;
    }

    public void setAppId(String appId) {
        this.set("dtyunxi.appId", appId);
        this.getMicroServiceContext().setAttachment("dtyunxi.appId", appId);
    }

    public String getAppSecret() {
        String value = (String)this.get("dtyunxi.appSecret");
        if (value == null) {
            value = this.getMicroServiceContext().getAttachment("dtyunxi.appSecret");
        }

        return value;
    }

    public void setAppSecret(String appSecret) {
        this.set("dtyunxi.appSecret", appSecret);
        this.getMicroServiceContext().setAttachment("dtyunxi.appSecret", appSecret);
    }

    public Long getRequestUserId() {
        String userId = (String)this.get("yes.req.userId");
        if (userId == null) {
            userId = this.getMicroServiceContext().getAttachment("yes.req.userId");
        }

        return userId != null ? Long.valueOf(userId) : null;
    }

    public String getRequestUserCode() {
        String value = (String)this.get("yes.req.userCode");
        if (value == null) {
            value = this.getMicroServiceContext().getAttachment("yes.req.userCode");
        }

        return value;
    }

    public Long getRequestApplicationId() {
        String applicationId = (String)this.get("yes.req.applicationId");
        if (applicationId == null) {
            applicationId = this.getMicroServiceContext().getAttachment("yes.req.applicationId");
        }

        return StringUtil.isEmpty(applicationId) ? null : Long.valueOf(applicationId);
    }

    public Long getRequestTenantId() {
        String tenantId = (String)this.get("yes.req.tenantId");
        if (tenantId == null) {
            tenantId = this.getMicroServiceContext().getAttachment("yes.req.tenantId");
        }

        if (StringUtil.isEmpty(tenantId)) {
            tenantId = "0";
        }

        return Long.valueOf(tenantId);
    }

    public Long getRequestInstanceId() {
        String targetId = (String)this.get("yes.req.instanceId");
        if (targetId == null) {
            targetId = this.getMicroServiceContext().getAttachment("yes.req.instanceId");
        }

        return StringUtil.isEmpty(targetId) ? 0L : Long.valueOf(targetId);
    }

    public Long getRequestUserUnitId() {
        String unitId = (String)this.get("unitId");
        if (unitId == null) {
            unitId = this.getMicroServiceContext().getAttachment("unitId");
        }

        return unitId != null ? Long.valueOf(unitId) : null;
    }

    public Long getRequestTenantCode() {
        String tenantCode = (String)this.get("yes.req.tenantCode");
        if (tenantCode == null) {
            tenantCode = this.getMicroServiceContext().getAttachment("yes.req.tenantCode");
        }

        if (StringUtil.isEmpty(tenantCode)) {
            tenantCode = "1";
        }

        return Long.valueOf(tenantCode);
    }

    public String getRequestUserIdString() {
        String value = (String)this.get("yes.req.userId");
        if (value == null) {
            value = this.getMicroServiceContext().getAttachment("yes.req.userId");
        }

        return value;
    }

    public String getRequestTerminalTypeString() {
        String value = (String)this.get("yes.req.terminal.type");
        if (value == null) {
            value = this.getMicroServiceContext().getAttachment("yes.req.terminal.type");
        }

        return value;
    }

    public String getRequestId() {
        String reqId = (String)this.get("yes.req.requestId");
        if (reqId == null) {
            reqId = this.getMicroServiceContext().getAttachment("yes.req.requestId");
        }

        return reqId;
    }

    public String getRequestOpenId() {
        String value = (String)this.get("yes.req.openId");
        if (value == null) {
            value = this.getMicroServiceContext().getAttachment("yes.req.openId");
        }

        return value;
    }

    public String getRequestUserType() {
        String value = (String)this.get("yes.req.userType");
        if (value == null) {
            value = this.getMicroServiceContext().getAttachment("yes.req.userType");
        }

        return value;
    }

    public String getRemoteIp() {
        String value = (String)this.get("yes.req.remoteIp");
        if (value == null) {
            value = this.getMicroServiceContext().getAttachment("yes.req.remoteIp");
        }

        return value;
    }
}