package com.gaoxi.tmp;

import com.taobao.pandora.boot.PandoraBootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public abstract class AbstractBoot {
    private Class<?> source;
    private String[] args;

    public AbstractBoot(Class<?> source, String... args) {
        this.source = source;
        this.args = args;
    }

    public ConfigurableApplicationContext run() throws Exception {
        this.setDiscoveryServer();
        Class clazzPandora = null;
        System.out.println("[DTYUNXI BOOT] DeployEnv=" + DeployEnv.getDeployEnv());
        if (DeployEnv.isEdas()) {
           // PandoraBootstrap bootstrap = new PandoraBootstrap();
            PandoraBootstrap.run(args);
            /*clazzPandora = Class.forName("com.taobao.pandora.boot.PandoraBootstrap");
            clazzPandora.getMethod("run", String[].class).invoke((Object)null, this.args);*/
        }

        this.execute();
        ConfigurableApplicationContext applicationContext = null;

        try {
            applicationContext = SpringApplication.run(this.source, this.args);
        } catch (NoSuchMethodError var5) {
            Class clazzSpringApp = Class.forName("org.springframework.boot.SpringApplication");
            applicationContext = (ConfigurableApplicationContext)clazzSpringApp.getMethod("run", Class.class, String[].class).invoke((Object)null, this.source, this.args);
        }

        if (clazzPandora != null) {
            clazzPandora.getMethod("markStartupAndWait", (Class[])null).invoke((Object)null, (Object[])null);
        }

        return applicationContext;
    }

    private void setDiscoveryServer() {
        String discoveryServer = System.getProperty("dtyunxi.discovery.server");
        if (discoveryServer != null) {
            if (DeployEnv.isEdas()) {
                System.setProperty("vipserver.server.port", discoveryServer);
            } else if (DeployEnv.isSpringCloudPure()) {
                System.setProperty("eureka.client.serviceUrl.defaultZone", discoveryServer);
            }
        }

    }

    public abstract void execute() throws Exception;
}