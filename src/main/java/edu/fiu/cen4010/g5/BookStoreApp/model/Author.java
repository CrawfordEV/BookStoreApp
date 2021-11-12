package edu.fiu.cen4010.g5.BookStoreApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("author")
public class Author {

    @Id
    private String id;
    @Field("firstname")
    private String firstname;
    @Field("lastname")
    private String lastname;
    @Field("biography")
    private String biography;
    @Field("publisher")
    private String publisher;

    public Author(String firstname, String lastname, String biography, String publisher) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.biography = biography;
        this.publisher = publisher;
    }

    public String getFullName(){
        return firstname + " " + lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBiography(){
        return biography;
    }

    public void setBiography(String biography){
        this.biography = biography;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

}