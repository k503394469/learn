package com.liu.itheima;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class T1 {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:1433/itheima?serverTimezone=UTC&characterEncoding=utf8","root","wocaibuhuiba555");
        String sql="select * from account";
        PreparedStatement ps=connection.prepareStatement(sql);
//        int count = ps.executeUpdate();
//        if (count>0){
//            System.out.println("success");
//        }else {
//            connection.rollback();
//            System.out.println(count);
//        }
//        System.out.println(count);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int bal = resultSet.getInt(3);
            System.out.print(id+" "+name+" "+bal+"\n");
        }
        ps.close();
        connection.close();
    }
}
