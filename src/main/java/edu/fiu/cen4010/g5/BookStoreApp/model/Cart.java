package edu.fiu.cen4010.g5.BookStoreApp.model;



import java.util.List;



//import java.util.ArrayList;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("cart")
public class Cart {

    @Id
    private String id;
    @Field("userId")
   // @Indexed(unique = true)
    private String userId;
    @Field("bookId") // books
    private String bookId;
    
    private List<Book> books;

    

    public Cart(String id, String bookId, String userId, List<Book> books)
    {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.books = books;
    }

    public String getId()
    {
        return id;
    }

    public void setID(String id)
    {
        this.id = id;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getBookId()
    {
        return bookId;
    }

    public void setTitle(String bookId)
    {
        this.bookId = bookId;
    }

    public List<Book> getCart() {
        return books;
    }

    public void setCart(String id, List<Book> books) {
        this.books = books;
        this.id = id;
    }

    
    
}