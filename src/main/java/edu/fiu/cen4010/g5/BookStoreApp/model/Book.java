package edu.fiu.cen4010.g5.BookStoreApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.ArrayList;

@Document("book")
public class Book {

    @Id
    private String id;
    @Field("isbn")
    @Indexed(unique = true)
    private String isbn;
    @Field("title")
    private String title;
    @Field("description")
    private String description;
    @Field("price")
    private float price;
    @Field("authors")
    private ArrayList<String> authors;
    @Field("genre")
    private Genre genre;
    @Field("publisher")
    private String publisher;
    @Field("yearpublished")
    private String yearpublished;
    @Field ("numsold")
    private long numsold;

    public Book(String isbn, String title, String description,
                float price, ArrayList<String> authors, Genre genre, String publisher,
                String yearpublished, long numsold) {

        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.price = price;
        this.authors = authors;
        this.genre = genre;
        this.publisher = publisher;
        this.yearpublished = yearpublished;
        this.numsold = numsold;
    }

    // don't delete, necessary for integration
    public Book() {
    }

    public String getId() {
        return id;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYearPublished() {
        return yearpublished;
    }

    public void setYearPublished(String yearpublished) {
        this.yearpublished = yearpublished;
    }

    public long getNumSold() {
        return numsold;
    }

    public void setNumSold(long numsold) {
        this.numsold = numsold;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", ISBN=" + isbn + ", title=" + title + ", price="
                + price + ", genre=" + genre +  "]";
    }
}