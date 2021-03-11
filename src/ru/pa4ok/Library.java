package ru.pa4ok;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Library
{
    private String title;
    private String address;
    private List<Book> books = new ArrayList<>();
    private Set<Author> authors = new HashSet<>();

    public Library(String title, String address) {
        this.title = title;
        this.address = address;
    }

    public void addBook(Book book)
    {
        books.add(book);
        if(authors.add(book.getAuthor())) {
            System.out.println("новый автор:" + book.getAuthor());
        }
    }

    public List<Book> getAuthorBooks(Author author)
    {
        List<Book> authorBooks = new ArrayList<>();
        for(Book b : books) {
            if(b.getAuthor().equals(author)) {
                authorBooks.add(b);
            }
        }
        return authorBooks;
    }

    public int deleteAuthor(Author author)
    {
        List<Book> toRemove = new ArrayList<>();

        for(Book b : books) {
            if(b.getAuthor().equals(author)) {
                toRemove.add(b);
            }
        }

        books.removeAll(toRemove);
        authors.remove(author);

        return toRemove.size();
    }

    @Override
    public String toString() {
        return "Library{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", books=" + books +
                ", authors=" + authors +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
