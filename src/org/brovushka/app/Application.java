package org.brovushka.app;

import org.brovushka.app.entity.ManufacturerEntity;
import org.brovushka.app.entity.ProductEntity;
import org.brovushka.app.manager.ManufacturerEntityManager;
import org.brovushka.app.manager.ProductEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Application
{

    /*
        ALT + INSERT - автогенерация (алт. пр. кнопка мышки -> generate)
        ALT + ENTER - вызов меню с возможными решениями ошибки
     */

    public static void main(String[] args) throws SQLException
    {
        //System.out.println(ProductEntityManager.getById(9));

        //System.out.println(ProductEntityManager.getAll());

        //System.out.println(ProductEntityManager.add(new ProductEntity("title", 44, "desc", "img", 1, 7)));

        /*ProductEntity p128 = ProductEntityManager.getById(128);
        p128.setActive(false);
        p128.setDescription("wer;gfjpoewfjpweoffewowfekfewefw");
        ProductEntityManager.edit(p128);*/

        //ProductEntityManager.delete(128);

        //-------------------------------------------------------------------------------------------------------

        //System.out.println(ManufacturerEntityManager.getById(4));

        //System.out.println(ManufacturerEntityManager.getAll());

        //System.out.println(ManufacturerEntityManager.add(new ManufacturerEntity("werpgojreijgreo", new Date())));

        /*ManufacturerEntity m51 = ManufacturerEntityManager.getById(51);
        m51.setName("new edited name");
        ManufacturerEntityManager.edit(m51);*/

        //ManufacturerEntityManager.delete(51);
    }

    //"короткий" способ подключения к базе
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam?serverTimeZone=UTC", "DemoExam","12345");
    }
}
