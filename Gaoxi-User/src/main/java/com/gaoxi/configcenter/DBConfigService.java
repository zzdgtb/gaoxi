package com.gaoxi.configcenter;

import org.springframework.beans.factory.annotation.Value;

import java.io.StringReader;
import java.sql.*;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class DBConfigService extends AbstractConfigService {

    //数据库地址
    @Value("${db.config.center.url}")
    private String dbUrl;
    @Value("${db.config.center.username}")
    private String dbUserName;
    @Value("${db.config.center.pwd}")
    private String dbPassword;
    @Value("db.config.center.driver")
    private String jdbcName;

    private Statement stmt;

    private Connection connection;

    @Override
    protected Object get0(String groupId, String dataId) {
        String content="";
        String sql = "select content from config where group_id='"+groupId+"' and data_id ='"+dataId+"'";
        try {
            PreparedStatement ps = connection.prepareStatement("select content from config where group_id= ? and data_id = ?");
            ps.setNCharacterStream(1, new StringReader(groupId), groupId.length());
            ps.setNCharacterStream(2, new StringReader(dataId), dataId.length());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                content=rs.getNString("content");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    protected void add0(String groupId, String dataId, String content) {
        String sql = "intsert into config('group_id','dataId') values('"+groupId+"','"+dataId+"')";
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void init0() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 加载驱动
            connection = DriverManager.getConnection(dbUrl,dbUserName,dbPassword); // 获取数据库连接
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
