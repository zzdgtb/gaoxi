package com.gaoxi.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import com.gaoxi.configcenter.AbstractConfigService;
import com.gaoxi.vo.DataSourceConfigVo;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {
        "com.gaoxi.mapper"
}, sqlSessionFactoryRef = "agentAppSqlSessionFactoryBean")
public class DataSourceConfig {
    @Autowired
    private AbstractConfigService configService;

    @Bean(name = {"dataSource"}, destroyMethod = "close")
    public DataSource dataSource() throws Exception {
        DataSourceConfigVo dataSourceVo = (DataSourceConfigVo)JSONObject.parseObject(this.configService.getConfig("mytest","datasource").toString(), DataSourceConfigVo.class);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataSourceVo.getJdbcUrl());
        dataSource.setUsername(dataSourceVo.getJdbcUserName());
        dataSource.setPassword(dataSourceVo.getJdbcUserPassword());

        dataSource.setInitialSize(1);
        dataSource.setMaxActive(3);

        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000L);
        dataSource.setValidationQuery(dataSourceVo.getValidationQuery());
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(60000L);
        dataSource.setMinEvictableIdleTimeMillis(25200000L);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(1800);
        dataSource.setLogAbandoned(true);
        dataSource.setFilters("mergeStat");

        dataSource.init();

        return dataSource;
    }

    @Bean(name = {"agentAppSqlSessionFactoryBean"})
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource") DataSource centerCommentDataSource)
            throws Exception {
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        config.setLogImpl(Slf4jImpl.class);
        config.setLogPrefix("dao.");

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(centerCommentDataSource);
        sqlSessionFactoryBean.setConfiguration(config);

        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        properties.setProperty("reasonable", "false");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**/*Mapper.xml"));
        // sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager centerTradeDataSourceTransactionManager(
            @Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
