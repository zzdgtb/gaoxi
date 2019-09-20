package com.gaoxi.test.chain.test;

import com.gaoxi.test.chain.callback.TransCallBack;
import com.gaoxi.test.chain.context.TransContext;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/20
 */
public class SendMsgCallBack implements TransCallBack {
    @Override
    public void onDone(TransContext transContext) {
        System.out.println("======执行回调方============");
    }
}
