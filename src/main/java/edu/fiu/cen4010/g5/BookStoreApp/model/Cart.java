package edu.fiu.cen4010.g5.BookStoreApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document("cart")
public class Cart {

    @Id
    private String id;
    @Field("userid")
    private String userid;
    @Field("books")
    private ArrayList<String> books;

    public Cart(String userid, ArrayList<String> books) {
        this.userid = userid;
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

    public String getUserid()
    {
        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<String> books) {
        this.books = books;
    }
}
