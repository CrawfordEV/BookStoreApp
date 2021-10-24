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
    //using mongo will allow double, but postman won't.
    //however, postman will allow Double.
    private Double price;
    /////////////////////////
    //Author goes here
    @Field("Author")//will work on next
    private Author author;
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

    public Book(String id, String ISBN, String title,String description,
                Double price /*, Author author*/, Genre genre, String bookPublisher,
                Integer publishedYear, Integer copiesSold) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.description = description;
        this.price = price;
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

    /*
@Id
private String id;
    @Field("isbn")
    @Indexed(unique = true)
    private String ISBN;
    @Field("title")//book name
    private String title;//bookName

    @Field("description")
    private String description;

    @Field("price")
    private double price;

    @Field("author")
    private Author author;
    @Field("genre")
    private Genre genre;
    @Field("bookPublisher")
    private String bookPublisher;
    @Field("publishedYear")
    private int publishedYear;
    @Field ("copiesSold")
    private BookSale copiesSold;


    public Book(String id, String ISBN, String title, String description,
                double price, Author author, Genre genre,
                String bookPublisher, int publishedYear, BookSale copiesSold) {

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

    //public void authorsFullName(Author firstName, Author lastName ){
    //      this.author = author;
//    }



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

    public int getPublishedYear(){
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear){
        this.publishedYear = publishedYear;
    }



    //changed to int
    //might even give book its own class

    //public String getPrice() {
    //  return PRICE;
    //}

//    public void setPrice(String PRICE) {
    //      this.PRICE = PRICE;
    //}

}*/