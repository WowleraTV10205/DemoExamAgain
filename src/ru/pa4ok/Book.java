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

    public Book(String title, String author, Date createDate, int pages, String shortDesc) {
        this.id = -1;
        this.title = title;
        this.author = author;
        this.createDate = createDate;
        this.pages = pages;
        this.shortDesc = shortDesc;
    }

    public Book() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && pages == book.pages && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(createDate, book.createDate) && Objects.equals(shortDesc, book.shortDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, createDate, pages, shortDesc);
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
