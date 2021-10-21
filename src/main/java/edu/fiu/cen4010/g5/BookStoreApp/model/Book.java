package edu.fiu.cen4010.g5.BookStoreApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("book")
public class Book {

    @Id
    private String id;
    @Field("isbn")
    @Indexed(unique = true)
    private String ISBN;
    @Field("title")
    private String title;
    @Field("genre")
    private Genre genre;

    public Book(String id, String ISBN, String title, Genre genre) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
