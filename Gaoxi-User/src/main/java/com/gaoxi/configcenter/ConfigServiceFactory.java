package com.gaoxi.configcenter;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class ConfigServiceFactory {

    public static AbstractConfigService createConfigService(String type){
        String configClass;
        switch (type){
            case "REDIS":
                configClass="com.gaoxi.configcenter.RedisConfigService";
                break;
            case "EDAS":
                configClass="com.gaoxi.configcenter.EdasConfigService";
                break;
            case "DB":
                configClass="com.gaoxi.configcenter.DBConfigService";
                break;
            default:
                configClass="com.gaoxi.configcenter.EdasConfigService";
                break;
        }
        try {
            return (AbstractConfigService)Class.forName(configClass).newInstance();
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
