package com.gaoxi.config;

import com.gaoxi.configcenter.AbstractConfigService;
import com.gaoxi.configcenter.ConfigServiceFactory;
import com.gaoxi.test.lifecycle.DefaultLifeCycleListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
@Configuration
@PropertySource({"classpath:config/config.properties"})
public class RootConfig {
    @Value("${config.center.type}")
    private String configCenterType;

    @Bean
    public AbstractConfigService registryService() {
        AbstractConfigService configService= ConfigServiceFactory.createConfigService(configCenterType);
        configService.addLifecycleListener(new DefaultLifeCycleListener());
        return configService;
    }

}
