package com.gaoxi.configcenter;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public interface IConfigService {

    Object getConfig(String groupId,String dataId);

    void addConfig(String groupId,String dataId,String content);
}
