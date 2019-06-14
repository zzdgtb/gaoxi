package com.gaoxi.configcenter;

import com.gaoxi.test.lifecycle.LifeCycleException;
import com.taobao.diamond.client.impl.DiamondEnvRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class EdasConfigService extends AbstractConfigService {
    private Logger logger = LoggerFactory.getLogger(EdasConfigService.class);
    @Override
    protected Object get0(String groupId, String dataId) {
        try {
            return DiamondEnvRepo.getDefaultEnv().getConfig(dataId, groupId, 3000);
        } catch (IOException e) {
           throw new LifeCycleException(e.getMessage());
        }
    }

    @Override
    protected void add0(String groupId, String dataId, String content) {
        DiamondEnvRepo.getDefaultEnv().publishSingle(dataId,groupId,content);
    }

    @Override
    protected void init0() {
        logger.info("edas初始化...");
    }
}
