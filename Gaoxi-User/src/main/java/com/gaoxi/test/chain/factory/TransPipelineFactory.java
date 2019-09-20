package com.gaoxi.test.chain.factory;


import com.gaoxi.test.chain.pipeline.TransPipeline;

/**
 * @author 西门
 * @version 0.1.0
 * @description
 * @date 2019/9/20
 */
public interface TransPipelineFactory<T> {

    TransPipeline build(T obj);
}
