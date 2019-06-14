package com.gaoxi.test.observe;

import com.google.common.base.Objects;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class Listener implements Listen {

    private String name;

    public Listener(String name){
        this.name=name;
    }
    @Override
    public void listen(Event evt) {
        System.out.println("监听者："+name+"监听到了事件:"+evt.getStatus());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listener listener = (Listener) o;
        return Objects.equal(name, listener.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
