package org.brovushka.app;

import org.brovushka.app.manager.ProductEntityManager;
import org.brovushka.app.manager.ProductSaleEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class Application
{
    public static void main(String[] args) throws SQLException
    {
        //System.out.println(ProductEntityManager.getAll());
        System.out.println(ProductSaleEntityManager.getAll());
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam?serverTimeZone=UTC&characterEncoding=utf8", "DemoExam", "12345");
    }
}
