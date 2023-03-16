package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo2_DriverManager {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver"); 5之后的版本可以省略
        //2. 获取连接   s2是数据库名 如果连接的是本机MySQL并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///s2?useSSL=false";
        String username = "root";
        String password = "Ygl990206";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql语句
        String sql = "update city1 set fid=1 where id=1";
        // 4. 获取执行sql的对象 statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        long count = stmt.executeLargeUpdate(sql);// 受影响的行
        //6.处理结果
        System.out.println(count);
        // 7. 释放资源
        stmt.close();
        conn.close();
    }
}
