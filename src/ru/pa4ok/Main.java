package ru.pa4ok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Main
{

    /*
        ALT + INSERT - автогенерация (алт. пр. кнопка мышки -> generate)
        ALT + ENTER - вызов меню с возможными решениями ошибки
     */

    public static void main(String[] args) throws SQLException
    {
        /*System.out.println(BookManager.add(new Book(
                -1,
                "test title",
                "test author",
                new Date(),
                228,
                "test desc"
        )));*/

        //System.out.println(BookManager.getById(3));

        //System.out.println(BookManager.getAll());


        /*Book book = BookManager.getById(3);
        book.setAuthor("new author pirgoirhgoegrgerwi");
        book.setCreateDate(new Date());
        System.out.println(BookManager.update(book));*/

        System.out.println(BookManager.deleteById(2));
    }

    //"короткий" способ подключения к базе
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam?serverTimeZone=UTC", "DemoExam","12345");
    }
}
