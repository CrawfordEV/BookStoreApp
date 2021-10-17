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
    @Field("title")//book name
    private String title;//bookName
    @Field("description")
    private String description;
    //this should be modified to fit with booksale
    @Field("price")//
    private double price;//
    //-----------------------------
    @Field("author")
    private Author author;
    @Field("genre")
    private Genre genre;
    @Field("bookPublisher")
    private String bookPublisher;
    @Field("publishedYear")
    private int publishedYear;
    @Field ("copiesSold")
    private int copiesSold;
    //use this when I update bookSale Class
    //private BookSale copiesSold;


    public Book(String id, String ISBN, String title, String description,
                double price, Author author, Genre genre,
                String bookPublisher, int publishedYear, /*BookSale copiesSold*/ int copiesSold) {

        //10 class instances
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

    //cant figure out a way to use superclasses, looks like it might
    //break format
    //need something to return the author's full name here
    /*
    public void authorsFullName(Author firstName, Author lastName ){
        this.author = author;
    }
*/


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

    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public Author getAuthor(){

        return author;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getBookPublisher(){
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher){
        this.bookPublisher = bookPublisher;
    }

    public int getPublishedYear(){
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear){
        this.publishedYear = publishedYear;
    }
/*
    public BookSale getCopiesSold(){
        return copiesSold;
    }

    public void setCopesSold(BookSale copiesSold){
        this.copiesSold = copiesSold;
    }
*/
    public int getCopiesSold(){
        return copiesSold;
    }
    public void setCopiesSold(int copiesSold){
        this.copiesSold = copiesSold;
    }
    //changed to int
    //might even give book its own class
    /*
    public String getPrice() {
        return PRICE;
    }

    public void setPrice(String PRICE) {
        this.PRICE = PRICE;
    }
    */
}