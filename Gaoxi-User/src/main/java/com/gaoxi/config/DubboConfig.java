package com.gaoxi.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.fastjson.JSONObject;
import com.gaoxi.configcenter.IConfigService;
import com.gaoxi.vo.DubboConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

    @Autowired
    private IConfigService configService;

    @Bean(name="dubboConfigVo")
    public DubboConfigVo DubboConfigVo(){
        DubboConfigVo dubboConfigVo = (DubboConfigVo) JSONObject.parseObject(this.configService.getConfig("mytest","dubbo").toString(), DubboConfigVo.class);
        return dubboConfigVo;
    }
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setCheck(false);
        consumerConfig.setTimeout(20000);
        return consumerConfig;
    }

    @Bean
    public ApplicationConfig applicationConfig(@Qualifier("dubboConfigVo")DubboConfigVo dubboConfigVo) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(dubboConfigVo.getName());

        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(@Qualifier("dubboConfigVo")DubboConfigVo dubboConfigVo) {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(dubboConfigVo.getRegestyAddress());
        //registryConfig.setClient("curator");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(@Qualifier("dubboConfigVo")DubboConfigVo dubboConfigVo)throws Exception {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(dubboConfigVo.getProtolPort());
        protocolConfig.setName(dubboConfigVo.getProtocolName());
        return protocolConfig;
    }

}
