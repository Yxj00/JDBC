package com.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC API 详解：Statement
 */
public class JDBCDemo4_Statement {
    /**
     * 执行DML语句  增删改
     * @throws Exception
     */
    @Test
    public void testDML() throws Exception{
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
        long count = stmt.executeLargeUpdate(sql);// 执行DML语句 ，受影响的行数
        //6.处理结果
//        System.out.println(count);
        if (count>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败~");
        }
        // 7. 释放资源
        stmt.close();
        conn.close();
    }
    /**
     * 执行DDL语句  create drop alter
     * @throws Exception
     */
    @Test
    public void testDDL() throws Exception{
        // 1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver"); 5之后的版本可以省略
        //2. 获取连接   s2是数据库名 如果连接的是本机MySQL并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///s2?useSSL=false";
        String username = "root";
        String password = "Ygl990206";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql语句
//        String sql = "create database ss2";
        String sql = "drop database ss2";
        // 4. 获取执行sql的对象 statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        long count = stmt.executeLargeUpdate(sql);// 执行DDL语句 ，可能是0
        //6.处理结果
//        System.out.println(count);
//        if (count>0){
//            System.out.println("修改成功");
//        }else {
//            System.out.println("修改失败~");
//        }
        System.out.println(count);
        // 7. 释放资源
        stmt.close();
        conn.close();
    }

}
