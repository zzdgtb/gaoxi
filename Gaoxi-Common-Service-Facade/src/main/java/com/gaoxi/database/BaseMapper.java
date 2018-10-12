package com.gaoxi.database;

/**
 * Created by Administrator on 2018/10/7.
 */

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 通用数据层接口，其他mapper请继承该mapper
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, InsertListMapper<T>{

}
