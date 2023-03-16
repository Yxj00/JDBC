package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo3_Connection {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver"); 5之后的版本可以省略
        //2. 获取连接   s2是数据库名 如果连接的是本机MySQL并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///s2?useSSL=false";
        String username = "root";
        String password = "Ygl990206";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql语句
        String sql1 = "update city1 set fid=1 where id=1";
        String sql2= "update city1 set fid=2 where id=2";
        // 4. 获取执行sql的对象 statement
        Statement stmt = conn.createStatement();



        try {
            //开启事务
            conn.setAutoCommit(false);
            //5.执行sql
            long count1 = stmt.executeLargeUpdate(sql1);// 受影响的行
            //6.处理结果
            System.out.println(count1);
            //5.执行sql
            long count2 = stmt.executeLargeUpdate(sql1);// 受影响的行
            //6.处理结果
            System.out.println(count2);

            // 提交事务
            conn.commit();
        } catch (Exception e) {
            // 回滚事务
            conn.rollback();
            e.printStackTrace();
        }


        //提交事务


        // 7. 释放资源
        stmt.close();
        conn.close();
    }
}
