package com.gaoxi.test.factory;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class CacheFactory {

    public static AbstractCacheService createCacheService(String cacheType){
        String cacheClassName;
        switch (cacheType){
            case "REDIS":
                cacheClassName="com.gaoxi.test.factory.RedisCacheService";
                break;
            case "MONGO":
                cacheClassName="com.gaoxi.test.factory.MongoCacheService";
                break;
            default:
                cacheClassName="com.gaoxi.test.factory.RedisCacheService";
                break;
        }
        try {
            return (AbstractCacheService)Class.forName(cacheClassName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
