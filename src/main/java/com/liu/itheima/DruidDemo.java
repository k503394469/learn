package com.liu.itheima;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args){
        Connection connection = null;
        PreparedStatement ps=null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql="insert into account(name,balance) values (?,?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,"wangwu");
            ps.setInt(2,4000);
            int i = ps.executeUpdate();
            System.out.println(i);
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(ps,connection);
        }


    }
}
