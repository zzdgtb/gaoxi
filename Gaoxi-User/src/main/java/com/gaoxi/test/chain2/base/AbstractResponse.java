package com.gaoxi.test.chain2.base;

import java.io.Serializable;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/29
 */
public class AbstractResponse implements Serializable {
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public AbstractResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public AbstractResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
