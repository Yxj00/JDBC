package com.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * API详解：PreparedStatement
 */
public class JDBCDemo7_PreparedStatement {

    @Test
    public void testPreparedStatement() throws Exception{

        //2. 获取连接   s2是数据库名 如果连接的是本机MySQL并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///s2?useSSL=false";
        String username = "root";
        String password = "Ygl990206";
        Connection conn = DriverManager.getConnection(url, username, password);
      // 接收用户输入 用户名和密码
        String name="张三";
        String pwd="' or '1' = '1";
        String sql="select * from tb_user where username=? and password=?";

        // 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置?的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        //执行sql语句
        ResultSet rs = pstmt.executeQuery();//这里不再传sql语句了

        // 判断登录是否成功
        if (rs.next()){
            System.out.println("登录成功~");
        }else {
            System.out.println("登录失败~");
        }
        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }

    /**
     * PreparedStatement原理
     * PreparedStatement预编译功能开启url后面加
     * useServerPrepStmts=true
     * @throws Exception
     */
    @Test
    public void testPreparedStatement2() throws Exception{

        //2. 获取连接   s2是数据库名 如果连接的是本机MySQL并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///s2?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "Ygl990206";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 接收用户输入 用户名和密码
        String name="张三";
        String pwd="' or '1' = '1";
        String sql="select * from tb_user where username=? and password=?";

        // 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置?的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        //执行sql语句
        ResultSet rs = pstmt.executeQuery();//这里不再传sql语句了

        // 判断登录是否成功
        if (rs.next()){
            System.out.println("登录成功~");
        }else {
            System.out.println("登录失败~");
        }
        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }
}


