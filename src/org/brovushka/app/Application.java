package org.brovushka.app;

import org.brovushka.app.ui.ProductTableForm;
import org.brovushka.app.util.DialogUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application
{

    /*
        ALT + INSERT - автогенерация (алт. пр. кнопка мышки -> generate)
        ALT + ENTER - вызов меню с возможными решениями ошибки
     */

    public static void main(String[] args) throws SQLException
    {
        new ProductTableForm();
    }

    //"короткий" способ подключения к базе
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam?serverTimeZone=UTC", "DemoExam","12345");
    }
}
