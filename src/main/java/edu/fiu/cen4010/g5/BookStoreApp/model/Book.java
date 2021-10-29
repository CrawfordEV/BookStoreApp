package edu.fiu.cen4010.g5.BookStoreApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//nope
import edu.fiu.cen4010.g5.BookStoreApp.model.Author;
import edu.fiu.cen4010.g5.BookStoreApp.repository.AuthorRepository;
import edu.fiu.cen4010.g5.BookStoreApp.service.AuthorService;

@Document("book")
public class Book {

    @Id
    private String id;
    @Field("isbn")
    @Indexed(unique = true)
    private String ISBN;
    @Field("title")
    private String title;
    @Field("description")
    private String description;
    @Field("price")
    private String price;
    @Field("author")
    private String author;
    @Field("genre")
    private String genre;
    @Field("bookPublisher")
    private String bookPublisher;
    @Field("publishedYear")
    private String publishedYear;
    @Field ("copiesSold")
    private String copiesSold;


    public Book(String id, String ISBN, String title,String description,
                String price, String author, String genre, String bookPublisher,
                String publishedYear, String copiesSold) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.description = description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.bookPublisher = bookPublisher;
        this.publishedYear = publishedYear;
        this.copiesSold = copiesSold;
       
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

    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice(){
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBookPublisher(){

        return bookPublisher;
    }
    public void setBookPublisher(String bookPublisher){
        this.bookPublisher = bookPublisher;
    }

    public String getPublishedYear(){
        return publishedYear;
    }
    public void setPublishedYear(String publishedYear){
        this.publishedYear = publishedYear;
    }

    public String getCopiesSold(){
        return copiesSold;
    }
    public void setCopiesSold(String copiesSold){
        this.copiesSold = copiesSold;
    }

}