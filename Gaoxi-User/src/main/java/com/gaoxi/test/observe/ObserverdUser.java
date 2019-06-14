package com.gaoxi.test.observe;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 被观察者对象
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public class ObserverdUser {
    /**
     * 监听者集合
     */
    private static Set<Listen> lisenSet = new HashSet<Listen>();
    /**
     * 监听者关心的事件
     */
    private Event evt;

    public void notice(){
        for(Listen listener:lisenSet){
            listener.listen(evt);
        }
    }

    public void registyListener(Listen listen){
        lisenSet.add(listen);
    }

    public void removeListener(Listen listen){
        lisenSet.remove(listen);
    }
    public Event getEvt() {
        return evt;
    }

    public ObserverdUser setEvt(Event evt) {
        this.evt = evt;
        return this;
    }

    public void doEvent(Event evt){
        setEvt(evt);
        notice();
    }
}
