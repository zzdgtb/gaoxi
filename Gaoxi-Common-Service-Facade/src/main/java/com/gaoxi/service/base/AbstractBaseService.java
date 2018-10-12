package com.gaoxi.service.base;
import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.gaoxi.database.BaseMapper;


/**
 * Created by Administrator on 2018/10/7.
 * 集成mybatis单表的增删查改基础操作
 */
public abstract class AbstractBaseService<M extends BaseMapper<T>, T extends Serializable>
        implements BaseService<T> {

    @Autowired
    protected M mapper;

    /*** insert start ***/
    public int insert(T t) {
        return this.mapper.insert(t);
    }

    public int insertSelective(T t) {
        return this.mapper.insertSelective(t);
    }

    public int insertList(List<T> t) {
        return this.mapper.insertList(t);
    }

    /*** insert end ***/

    /*** delete start ***/
    
    public int delete(T t) {
        return mapper.delete(t);
    }

    public int deleteByExample(Object o) {
        return this.mapper.deleteByExample(o);
    }

    public int deleteByPrimaryKey(Object o) {
        return this.mapper.deleteByPrimaryKey(o);
    }

    /*** delete end ***/

    /*** update start ***/
    @Override
    public int updateByPrimaryKey(T t) {
        return this.mapper.updateByPrimaryKey(t);
    }

    @Override
    public int updateByExample(T t, Object o) {
        return this.mapper.updateByExample(t, o);
    }

    @Override
    public int updateByExampleSelective(T t, Object o) {
        return this.mapper.updateByExampleSelective(t, o);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return this.mapper.updateByPrimaryKeySelective(t);
    }

    /*** update end ***/

    /*** select start ***/
    public List<T> select(T t) {
        return this.mapper.select(t);
    }

    public List<T> selectAll() {
        return this.mapper.selectAll();
    }

    public List<T> selectByExample(Object o) {
        return this.mapper.selectByExample(o);
    }

    public List<T> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return this.mapper.selectByExampleAndRowBounds(o, rowBounds);
    }

    public T selectByPrimaryKey(Object o) {
        return this.mapper.selectByPrimaryKey(o);
    }

    public List<T> selectByRowBounds(T t, RowBounds rowBounds) {
        return this.mapper.selectByRowBounds(t, rowBounds);
    }

    public int selectCount(T t) {
        return this.mapper.selectCount(t);
    }

    public int selectCountByExample(Object o) {
        return this.mapper.selectCountByExample(o);
    }

    public T selectOne(T t) {
        return this.mapper.selectOne(t);
    }

    public T selectOneByExample(Object o) {
        return this.mapper.selectOneByExample(o);
    }

    public boolean existsWithPrimaryKey(Object o) {
        return this.mapper.existsWithPrimaryKey(o);
    }

    /*** select end ***/

}