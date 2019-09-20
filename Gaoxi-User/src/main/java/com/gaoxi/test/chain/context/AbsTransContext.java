package com.gaoxi.test.chain.context;

import com.gaoxi.test.chain.convert.TransConvert;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/20
 */
public abstract class AbsTransContext implements TransContext{

    private TransConvert convert = null;

    public TransConvert getConvert() {
        return convert;
    }

    public AbsTransContext setConvert(TransConvert convert) {
        this.convert = convert;
        return this;
    }
}
