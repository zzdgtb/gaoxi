package com.gaoxi.configcenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class RedisConfigService extends AbstractConfigService {

    private Logger logger = LoggerFactory.getLogger(EdasConfigService.class);

    private Jedis jedis;
    @Value("${redis.config.center.url}")
    private String redisConfigCenterUrl;

    @Override
    protected Object get0(String groupId, String dataId) {
        return jedis.get(groupId+"_"+dataId);
    }

    @Override
    protected void add0(String groupId, String dataId, String content) {
        jedis.set(groupId+"_"+dataId,content);
    }

    @Override
    protected void init0() {
        jedis = new Jedis(redisConfigCenterUrl);
        logger.info("redis config center Connection to" +redisConfigCenterUrl+ "sucessfully");
    }
}
