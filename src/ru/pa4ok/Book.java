package ru.pa4ok;

import java.util.Date;
import java.util.Objects;

public class Book
{
    private int id;
    private String title;
    private String author;
    private Date createDate;
    private int pages;
    private String shortDesc;

    public Book(int id, String title, String author, Date createDate, int pages, String shortDesc) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createDate = createDate;
        this.pages = pages;
        this.shortDesc = shortDesc;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", createDate=" + createDate +
                ", pages=" + pages +
                ", shortDesc='" + shortDesc + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
}
