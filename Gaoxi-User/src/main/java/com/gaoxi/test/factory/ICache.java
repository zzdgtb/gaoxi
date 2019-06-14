package com.gaoxi.test.factory;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public interface ICache {
    void set(String key,Object val);

     Object get(String key);

}
