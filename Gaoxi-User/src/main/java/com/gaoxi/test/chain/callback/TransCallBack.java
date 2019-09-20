package com.gaoxi.test.chain.callback;

import com.gaoxi.test.chain.context.TransContext;

/**
 * @author 西门
 * @version 0.1.0
 * @description 回调
 * @date 2019/9/20
 */
public interface TransCallBack {

    void onDone(TransContext transContext);
}
