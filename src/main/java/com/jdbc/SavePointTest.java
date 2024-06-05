package com.jdbc;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class SavePointTest {
    private Connection connection;
    @Before
    public void initConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboot?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", "root", "");
    }
    @Test
    public void test(){
        Savepoint sp1;
        Savepoint sp2;
        try {
            connection.setAutoCommit(false);
            sp1 = connection.setSavepoint("sp1");
            insert("insert into t_person(name,address)values('savepoint1','address1')");
            sp2 = connection.setSavepoint("sp2");
            insert("insert into t_person(name,address)values('savepoint2','address2')");
            connection.rollback(sp2);
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void insert(String sql) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
