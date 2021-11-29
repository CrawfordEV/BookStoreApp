package edu.fiu.cen4010.g5.BookStoreApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document("rating")
public class Rating {

    @Id
    private String id;
    @Indexed
    @Field("userid")
    private String userid;
    @Indexed
    @Field("bookid")
    private String bookid;
    @Field("value")
    private int value;
    @Field("date")
    private String date;
    @Field("comment")
    private String comment;

    public Rating(String userid, String bookid, int value, String comment) {
        this.userid = userid;
        this.bookid = bookid;
        this.value = value;
        this.date = LocalDateTime.now().toString();
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

