package com.springcloudalibaba.user;

import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceTest {

    @Test
    public void testJdbc() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.47.129:3306/user?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC", "root", "root");

        System.out.println(conn);


    }
}
