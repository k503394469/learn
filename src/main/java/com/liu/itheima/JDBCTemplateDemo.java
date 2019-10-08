package com.liu.itheima;

import com.liu.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTemplateDemo {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void main(String[] args) {
        //创建JDBCTemplate
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用
        String sql = "update account set balance=5000 where id=?";
        int update = jt.update(sql, 1);
        System.out.println(update);
    }

    @Test
    public void jtLearn1() {
        String sql = "update account set balance=? where name=?";
        int update = jt.update(sql, 10000, "zhangsan");
        System.out.println(update);
    }

    @Test
    public void jtLearn2() {
        String sql = "select * from account";
        Map<String, Object> stringObjectMap = jt.queryForMap(sql);
        System.out.println(stringObjectMap);
    }

    @Test
    public void jtLearn3() {
        String sql = "select * from account";
        List<Map<String, Object>> maps = jt.queryForList(sql);
        System.out.println(maps);
    }

    @Test
    public void jtLearn4() {
        String sql = "select * from account";
        List<Account> accounts = jt.query(sql, (resultSet, i) -> {
            Account a=new Account();
            a.setId(resultSet.getInt(1));
            a.setName(resultSet.getString(2));
            a.setBalance(resultSet.getInt(3));
            return a;
        });
        System.out.println(accounts);
    }
    @Test
    public void jtLearn4_2() {
        String sql = "select * from account";
        List<Account> query = jt.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(query);
    }
    @Test
    public void jtLearn5() {
        String sql = "select count(*) from account";
        Integer account = jt.queryForObject(sql,Integer.class);
        System.out.println(account);
    }
}
