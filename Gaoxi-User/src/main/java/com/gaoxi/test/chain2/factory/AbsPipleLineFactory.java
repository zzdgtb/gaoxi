package com.gaoxi.test.chain2.factory;

import com.gaoxi.test.chain2.base.AbstractRequest;
import com.gaoxi.test.chain2.context.BaseContext;
import com.gaoxi.test.chain2.convert.BaseConvert;
import com.gaoxi.test.chain2.pipleline.BasePipleLine;
import com.gaoxi.test.chain2.pipleline.DefaultPipleLine;

/**
 * @author 西门
 * @version 0.1.0
 * @description ${description}
 * @date 2019/9/29
 */
public abstract class AbsPipleLineFactory implements PipleFacotory{

    @Override
    public BasePipleLine createPipleLine(AbstractRequest absRequest) {
        //创建转换器
        BaseConvert convert = createConvert(absRequest);
        //创建上下文
        BaseContext baseContext = convert.request2Context(absRequest);
        //创建管道
        DefaultPipleLine piple = new DefaultPipleLine(baseContext);

        doBuild(piple);
        
        return piple;
    }

    protected abstract void doBuild(DefaultPipleLine piple);

    protected abstract BaseConvert createConvert(AbstractRequest absRequest);
}
