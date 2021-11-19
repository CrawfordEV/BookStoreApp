package edu.fiu.cen4010.g5.BookStoreApp.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("wishlist")
public class Wishlist {

    @Id
    private String id;
    @Field("userid")
    private String userid;
    @Field("books")
    private ArrayList<String> books;
    @Field("wishlist name")
    private String wishlistName;

    public Wishlist(String userid, ArrayList<String> books, String wishlistName) {
        this.userid = userid;
        this.books = books;
        this.wishlistName = wishlistName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<String> books) {
        this.books = books;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }
}
