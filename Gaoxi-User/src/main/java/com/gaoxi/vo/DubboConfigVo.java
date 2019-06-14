package com.gaoxi.vo;

import java.io.Serializable;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class DubboConfigVo implements Serializable {
    
    private String regestyAddress;

    private String name;

    private int protolPort;

    private String protocolName;

    public String getRegestyAddress() {
        return regestyAddress;
    }

    public DubboConfigVo setRegestyAddress(String regestyAddress) {
        this.regestyAddress = regestyAddress;
        return this;
    }

    public String getName() {
        return name;
    }

    public DubboConfigVo setName(String name) {
        this.name = name;
        return this;
    }

    public int getProtolPort() {
        return protolPort;
    }

    public DubboConfigVo setProtolPort(int protolPort) {
        this.protolPort = protolPort;
        return this;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public DubboConfigVo setProtocolName(String protocolName) {
        this.protocolName = protocolName;
        return this;
    }
}
