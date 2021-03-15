package ru.pa4ok;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager
{
    /*
    private int id;
    private String title;
    private String author;
    private Date createDate;
    private int pages;
    private String shortDesc;
     */

    public static Book add(Book book) throws SQLException
    {
        try(Connection c = Main.getConnection())
        {
            String sql = "INSERT INTO books(title, auhor, createDate, pages, shortDesc) VALUES(?,?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setTimestamp(3, new Timestamp(book.getCreateDate().getTime()));
            ps.setInt(4, book.getPages());
            ps.setString(5, book.getShortDesc());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                book.setId(keys.getInt(1));
                return book;
            }

            throw new SQLException("entity not added");
        }
    }

    public static Book getById(int id) throws SQLException
    {
        try(Connection c = Main.getConnection())
        {
            String sql = "SELECT * FROM books WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                return new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("auhor"),
                        resultSet.getTimestamp("createDate"),
                        resultSet.getInt("pages"),
                        resultSet.getString("shortDesc")
                );
            }

            return null;
        }
    }

    public static List<Book> getAll() throws SQLException
    {
        try(Connection c = Main.getConnection())
        {
            String sql = "SELECT * FROM books";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<Book> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("auhor"),
                        resultSet.getTimestamp("createDate"),
                        resultSet.getInt("pages"),
                        resultSet.getString("shortDesc")
                ));
            }

            return list;
        }
    }

    public static int update(Book book) throws SQLException
    {
        try(Connection c = Main.getConnection())
        {
            String sql = "UPDATE books SET title=?, auhor=?, createDate=?, pages=?, shortDesc=? WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setTimestamp(3, new Timestamp(book.getCreateDate().getTime()));
            ps.setInt(4, book.getPages());
            ps.setString(5, book.getShortDesc());
            ps.setInt(6, book.getId());

            return ps.executeUpdate();
        }
    }

    public static int delete(int id) throws SQLException
    {
        try (Connection c = Main.getConnection())
        {
            String sql = "DELETE FROM books WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate();
        }
    }

    public static int delete(Book book) throws SQLException
    {
        return delete(book.getId());
    }
}






















