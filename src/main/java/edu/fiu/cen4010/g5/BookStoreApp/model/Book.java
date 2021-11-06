package edu.fiu.cen4010.g5.BookStoreApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

//nope

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
    //using mongo will allow double, but postman won't.
    //however, postman will allow Double.
    private Double price;
    /////////////////////////
    //Author goes here
    @Field("author")//will work on next
    private ArrayList<String> authorids;
    ///////////////////////
    @Field("genre")
    private Genre genre;
    @Field("bookPublisher")
    private String bookPublisher;
    @Field("publishedYear")
    //if I use int for year, mongo will save the data,
    //but postman won't read it
    private Integer publishedYear;
    @Field ("copiesSold")
    private Integer copiesSold;

    //private String bookFullName;

    public Book(String id, String ISBN, String title, String description,
                Double price, ArrayList<String> authorids, Genre genre, String bookPublisher,
                Integer publishedYear, Integer copiesSold) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.description = description;
        this.price = price;
        this.authorids = authorids;
        this.genre = genre;
        this.bookPublisher = bookPublisher;
        this.publishedYear = publishedYear;
        this.copiesSold = copiesSold;
        //nope
        //authorRepository.findByFullName(fullName)
    }
    //nope
   // public String bookFullName(){
        //authorService.getAuthorByFullName(fullName);
     //  return null; //bookFullName = Author.fullName();
    //}

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
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public ArrayList<String> getAuthorids(){
        return authorids;
    }
    public void setAuthorids(ArrayList<String> authorids){
        this.authorids = authorids;
    }
    public Genre getGenre() {
        return genre;
    }
    //name still needs to be implemented here
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public String getBookPublisher(){

        return bookPublisher;
    }
    public void setBookPublisher(String bookPublisher){
        this.bookPublisher = bookPublisher;
    }
    public Integer getPublishedYear(){
        return publishedYear;
    }
    public void setPublishedYear(Integer publishedYear){
        this.publishedYear = publishedYear;
    }

    public Integer getCopiesSold(){
        return copiesSold;
    }

    public void setCopiesSold(Integer copiesSold){
        this.copiesSold = copiesSold;
    }

    //@Override
    //public String toString() {
    //    return "Book [id=" + id + ", ISBN=" + ISBN + ", title=" + title + ", price="
    //            + price + ", genre=" + genre +  "]";
    //}
}