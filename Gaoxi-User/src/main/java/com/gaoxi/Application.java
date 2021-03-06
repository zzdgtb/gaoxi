package com.gaoxi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@MapperScan(basePackages = {"com.gaoxi.mapper"})
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) throws Exception{
        //PandoraBootstrap.run(args);
        //initLogger();
        System.setProperty("yes.log.version", "0.1.0");
        System.setProperty("yes.server.localHost", "127.0.0.1");

        //Object obj = DiamondEnvRepo.getDefaultEnv().getConfig("agent.app.centerHttpVo", "gaoxi-iservice-dev", 3000);

        /*System.setProperty("yes.log.version", "0.1.0");
        System.setProperty("gaoxi.env.module", "DEV");*/
        new SpringApplicationBuilder(Application.class).run(args);
        /*new AbstractBoot(Application.class, args) {
            @Override
            public void execute() throws Exception {
                LoggerServletFilter.initLogger();
            }
        }.run();*/

    }
}


