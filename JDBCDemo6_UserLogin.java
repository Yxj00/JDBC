package com.jdbc;

import com.pojo.Account;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户登录
 */
public class JDBCDemo6_UserLogin {

    @Test
    public void testLogin() throws Exception{

        //2. 获取连接   s2是数据库名 如果连接的是本机MySQL并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///s2?useSSL=false";
        String username = "root";
        String password = "Ygl990206";
        Connection conn = DriverManager.getConnection(url, username, password);
      // 接收用户输入 用户名和密码
        String name="张三";
        String pwd="123";
        String sql="select * from tb_user where username='"+name+"' and password='"+pwd+"'";

        // 获取stmt对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 判断登录是否成功
        if (rs.next()){
            System.out.println("登录成功~");
        }else {
            System.out.println("登录失败~");
        }
        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

    /**
     * 演示SQL注入
     * @throws Exception
     */
    @Test
    public void testLogin_Inject() throws Exception{

        //2. 获取连接   s2是数据库名 如果连接的是本机MySQL并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///s2?useSSL=false";
        String username = "root";
        String password = "Ygl990206";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 接收用户输入 用户名和密码
        String name="张四";
        String pwd="' or '1' = '1";// 别看有红  但是可以运行

        String sql="select * from tb_user where username='"+name+"' and password='"+pwd+"'";
        System.out.println(sql);
        // 获取stmt对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 判断登录是否成功
        if (rs.next()){
            System.out.println("登录成功~");
        }else {
            System.out.println("登录失败~");
        }
        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}


