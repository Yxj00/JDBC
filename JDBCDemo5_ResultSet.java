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
 * JDBC API 详解：ResultSet
 */
public class JDBCDemo5_ResultSet {
    /**
     * 执行DQL
     * @throws Exception
     */
    @Test
    public void testResultSet() throws Exception{
        // 1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver"); 5之后的版本可以省略
        //2. 获取连接   s2是数据库名 如果连接的是本机MySQL并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///s2?useSSL=false";
        String username = "root";
        String password = "Ygl990206";
        Connection conn = DriverManager.getConnection(url, username, password);
       // 3.定义sql
        String sql ="select * from job";
        // 4.获取statement对象
        Statement stmt = conn.createStatement();
        // 5.执行sql
        ResultSet rs = stmt.executeQuery(sql);
        // 6.处理结果 遍历rs中的所有数据
        // 6.1 光标向下移动一行，并且判断当前行是否有数据
    /*    while (rs.next()){
            // 6.2获取数据 getXxx()
            int id = rs.getInt(1);
            String jname = rs.getString(2);
            System.out.print(id+"\t");
            System.out.println(jname);
            System.out.println("------------");
        }*/
        while (rs.next()){
            // 6.2获取数据 getXxx()
            int id = rs.getInt("id");
            String jname = rs.getString("jname");
            System.out.print(id+"\t");
            System.out.println(jname);
            System.out.println("------------");
        }
        //7.释放资源
        rs.close();
        conn.close();
    }
    /**
     * 查询job表的数据，封装为Account对象中，并且存储到ArrayList集合中
     * 1. 定义实体类Account
     * 2.查询数据，封装到Account对象中
     * 3.将Account对象存入ArrayList集合中
     * @throws Exception
     */
    @Test
    public void testResultSet2() throws Exception{
        // 1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver"); 5之后的版本可以省略
        //2. 获取连接   s2是数据库名 如果连接的是本机MySQL并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///s2?useSSL=false";
        String username = "root";
        String password = "Ygl990206";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3.定义sql
        String sql ="select * from job";
        // 4.获取statement对象
        Statement stmt = conn.createStatement();
        // 5.执行sql
        ResultSet rs = stmt.executeQuery(sql);
        //创建集合
       List<Account> list = new ArrayList<>();

        while (rs.next()){
            Account account=new Account();

            // 6.2获取数据 getXxx()
            int id = rs.getInt("id");
            String jname = rs.getString("jname");
          //赋值
            account.setId(id);
            account.setJname(jname);

            //存入集合
            list.add(account);
        }
        System.out.println(list);
        //7.释放资源
        rs.close();
        conn.close();
    }
    }


