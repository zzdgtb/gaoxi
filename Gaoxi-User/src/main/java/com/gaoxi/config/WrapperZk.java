package com.gaoxi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/8/27
 */
@Data
@Component
@ConfigurationProperties(prefix = "curator")
public class WrapperZk {

    private int retryCount;

    private int elapsedTimeMs;

    private String connectString;

    private int sessionTimeoutMs;

    private int connectionTimeoutMs;

    public int getRetryCount() {
        return retryCount;
    }

    public WrapperZk setRetryCount(int retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    public int getElapsedTimeMs() {
        return elapsedTimeMs;
    }

    public WrapperZk setElapsedTimeMs(int elapsedTimeMs) {
        this.elapsedTimeMs = elapsedTimeMs;
        return this;
    }

    public String getConnectString() {
        return connectString;
    }

    public WrapperZk setConnectString(String connectString) {
        this.connectString = connectString;
        return this;
    }

    public int getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public WrapperZk setSessionTimeoutMs(int sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
        return this;
    }

    public int getConnectionTimeoutMs() {
        return connectionTimeoutMs;
    }

    public WrapperZk setConnectionTimeoutMs(int connectionTimeoutMs) {
        this.connectionTimeoutMs = connectionTimeoutMs;
        return this;
    }
}