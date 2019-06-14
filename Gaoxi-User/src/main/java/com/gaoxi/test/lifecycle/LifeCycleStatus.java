package com.gaoxi.test.lifecycle;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/27
 * @version: 1.0.0
 */
public enum StatusEnum {

    NEW, //新生

    INITIALIZING, INITIALIZED,//初始化

    STARTING,STARTED,//启动

    SUSPENDING,SUSPENDED,//暂停

    RESUMING,RESUMED,//恢复

    DESTROYING,DESTROYED,//销毁

    FAILED;//失败
}
