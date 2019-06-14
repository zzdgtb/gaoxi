package com.gaoxi.test.factory;

import com.alibaba.dubbo.common.json.JSON;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class RedisCacheService extends  AbstractCacheService {

    private Jedis jedis;

    @Override
    protected void set0(String key, Object val) {
        if(val instanceof String){
            jedis.set(key,(String)val);
            return;
        }
        try {
            jedis.set(key, JSON.json(val));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object get0(String key) {
        return jedis.get(key);
    }

    @Override
    protected void init0() {

        jedis = new Jedis("127.0.0.1");

        System.out.println("Connection to server sucessfully");

        System.out.println("Server is running: "+jedis.ping());
    }

    @Override
    protected void destroy0() {
        jedis.close();
    }

}
