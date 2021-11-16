package edu.fiu.cen4010.g5.BookStoreApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("wishlist")
public class Wishlist {

    @Id
    public String id;
    @Field("userid")
    @Indexed(unique = true)
    private String userid;
    @Field("isbn")
    @Indexed(unique = true)
    private String ISBN;
    @Field("title")
    private String title;
    @Field("genre")
    private Genre genre;
    @Field("wishlist name")
    private String wishlistName;

    public Wishlist(String id,String userid, String ISBN, String title, Genre genre, String wishlistName) {
        this.id = id;
        this.userid = userid;
        this.ISBN = ISBN;
        this.title = title;
        this.genre = genre;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String bookid) {
        this.ISBN = bookid;
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

    public String getwishlistName() {
        return wishlistName;
    }

    public void setwishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }
}
