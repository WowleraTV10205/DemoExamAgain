package ru.pa4ok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        /*System.out.println(BookManager.add(
                new Book(
                        -1,
                        "ewfopog",
                        "ewfohefewf",
                        new Date(),
                        43434,
                        "wepjeofhewoighoe[whfgo[wehgowehgeo[whgwo[ghewoi[g"
                )
        ));*/

        //System.out.println(BookManager.getById(5));

        /*Book b5 = BookManager.getById(5);
        b5.setAuthor("new super author");
        b5.setPages(229);
        BookManager.update(b5);*/

        //System.out.println(BookManager.getAll());
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(
                "jdbc:mysql://116.202.236.174:3306/DemoExam?serverTimeZone=UTC&characterEncoding=utf8",
                "DemoExam",
                "12345"
        );
    }
}
