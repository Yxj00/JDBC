package com.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid数据库连接池
 *
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包

        // 2.定义配置文件

        // 3.加载配置文件
        Properties prop = new Properties();
        prop.load(Files.newInputStream(Paths.get("F:/Idea/ideaProjects/myJDBC/src/druid.properties")));//路径
        // 4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5.获取数据库连接 Connection
        Connection connection = dataSource.getConnection();
        System.out.println(connection);


//        System.out.println(System.getProperty("user.dir"));// 查看当前文件路径
    }
}
