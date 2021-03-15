package ru.pa4ok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        /*System.out.println(BookManager.add(new Book(
                "mybook",
                "pa4ok",
                new Date(),
                2112,
                "descriptionefw[pevkwe[gke[w"
        )));*/

        //System.out.println(BookManager.getById(7));

        //System.out.println(BookManager.getAll());

        /*Book b7 = BookManager.getById(7);
        b7.setPages(4444);
        b7.setCreateDate(new Date());
        b7.setTitle("b73434434344");
        BookManager.update(b7);*/

        BookManager.delete(3);
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam?serverTimeZone=UTC&characterEncoding=utf8", "DemoExam", "12345");
    }
}
