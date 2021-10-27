package edu.fiu.cen4010.g5.BookStoreApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("author")
public class Author {

    @Id
    private String id;
    @Field("firstName")
    private String firstName;
    @Field("lastName")
    private String lastName;
    @Field("biography")
    private String biography;
    @Field("publisher")
    private String publisher;
    //no field needed here
    private String fullName;

    public Author(String id, String firstName, String lastName, String biography, String publisher){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
        fullName();
        //fullName = firstName + " " + lastName;
    }
    //if bookauthor = author
    //then showbook
    //or something like that

    //method to show the full name of the author
    public String fullName(){
        return fullName = firstName + " " + lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

}