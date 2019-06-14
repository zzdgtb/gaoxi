package com.gaoxi.test.observe;

/**
 * @Description: 监听的事件
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class Event {
    /**
     * 关心的状态
     */
    private String status;

    public Event(String status){
        this.status=status;
    }
    public String getStatus() {
        return status;
    }

    public Event setStatus(String status) {
        this.status = status;
        return this;
    }
}
