package com.liu.itheima;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception{
        Properties pro=new Properties();
        InputStream resourceAsStream = DruidDemo.class.getResourceAsStream("/druid.properties");
        pro.load(resourceAsStream);
        Connection connection = DruidDataSourceFactory.createDataSource(pro).getConnection();

        System.out.println(connection);

    }
}
