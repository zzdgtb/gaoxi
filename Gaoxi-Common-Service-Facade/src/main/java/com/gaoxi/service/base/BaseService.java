package com.gaoxi.service.base;

/**
 * Created by Administrator on 2018/10/7.
 */

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface BaseService<T> {
    int insert(T t);

    int insertSelective(T t);

    int insertList(List<T> t);

    int delete(T t);

    int deleteByExample(Object o);

    int deleteByPrimaryKey(Object o);

    int updateByPrimaryKey(T t);

    int updateByExample(T t, Object o);

    int updateByExampleSelective(T t, Object o);

    int updateByPrimaryKeySelective(T t);

    List<T> select(T t);

    List<T> selectAll();

    List<T> selectByExample(Object o);

    List<T> selectByExampleAndRowBounds(Object o, RowBounds rowBounds);

    T selectByPrimaryKey(Object o);

    List<T> selectByRowBounds(T t, RowBounds rowBounds);

    int selectCount(T t);

    int selectCountByExample(Object o);

    T selectOne(T t);

    T selectOneByExample(Object o);

    boolean existsWithPrimaryKey(Object o);
}