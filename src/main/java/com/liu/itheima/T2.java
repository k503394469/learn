package com.liu.itheima;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

/**
 * c3p0连接池测试
 */
public class T2 {
    public static void main(String[] args) throws Exception{
        ComboPooledDataSource cpds=new ComboPooledDataSource();
        Connection connection = cpds.getConnection();
        System.out.println(connection.toString());

    }
}
