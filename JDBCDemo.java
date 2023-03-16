package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver"); 5之后的版本可以省略
        //2. 获取连接   s2是数据库名
        String url = "jdbc:mysql://localhost:3306/s2";
        String username = "root";
        String password = "Ygl990206";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql语句
        String sql = "update city1 set fid=1 where id=1";
        // 4. 获取执行sql的对象 statement
        Statement stmt = conn.createStatement();
        //5.执行sql
       int count = stmt.executeUpdate(sql);// 受影响的行
        //6.处理结果
        System.out.println(count);
        // 7. 释放资源
        stmt.close();
        conn.close();
    }
}
