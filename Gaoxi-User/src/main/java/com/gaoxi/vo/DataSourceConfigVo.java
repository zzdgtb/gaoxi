package com.gaoxi.vo;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class DataSourceConfigVo {

    private String driverClassName;
    private String jdbcUrl;
    private String jdbcUserName;
    private String jdbcUserPassword;
    private String validationQuery;
    private int initialSize;
    private int maxActive;
    private int minIdle;
    private int maxWait;

    public String getDriverClassName() {
        return driverClassName;
    }

    public DataSourceConfigVo setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public DataSourceConfigVo setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
        return this;
    }

    public String getJdbcUserName() {
        return jdbcUserName;
    }

    public DataSourceConfigVo setJdbcUserName(String jdbcUserName) {
        this.jdbcUserName = jdbcUserName;
        return this;
    }

    public String getJdbcUserPassword() {
        return jdbcUserPassword;
    }

    public DataSourceConfigVo setJdbcUserPassword(String jdbcUserPassword) {
        this.jdbcUserPassword = jdbcUserPassword;
        return this;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public DataSourceConfigVo setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
        return this;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public DataSourceConfigVo setInitialSize(int initialSize) {
        this.initialSize = initialSize;
        return this;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public DataSourceConfigVo setMaxActive(int maxActive) {
        this.maxActive = maxActive;
        return this;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public DataSourceConfigVo setMinIdle(int minIdle) {
        this.minIdle = minIdle;
        return this;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public DataSourceConfigVo setMaxWait(int maxWait) {
        this.maxWait = maxWait;
        return this;
    }
}
