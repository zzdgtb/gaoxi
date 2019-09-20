package com.gaoxi.test.chain.base;

import java.io.Serializable;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/20
 */
public abstract class AbstractResponse implements Serializable {

    private static final long serialVersionUID = -6003232171426099187L;

    private String code;
    private String msg;

    public AbstractResponse() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
