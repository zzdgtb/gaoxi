package com.gaoxi.test.factory;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class Test {

    public static void main(String[] args){
        AbstractCacheService cacheService = CacheFactory.createCacheService("MONGO");
        cacheService.set("hahah","哈哈哈");
        //cacheService.destroy();
        System.out.println(cacheService.get("hahah"));

        User user = new User("admin","123");

        cacheService.set(user.getName(),user);
        System.out.println(cacheService.get(user.getName()));
    }
}
