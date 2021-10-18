
package edu.fiu.cen4010.g5.BookStoreApp.model;
/*
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("author")
public class Author {

    @Id
    private String id;
    @Field("firstname")
    private String firstName;
    @Field("lastname")
    private String lastName;

    //must be able to get a list of books associated with an author
    //might not need this

    //@Field("authorBookList")
    //private String authorBookList;
    @Field("biography")//will need to support a paragraph or less of strings or chars
    private String biography;
    @Field("authorPublisher")//not sure if this is supposed to connect to the book publisher as well
    private String authorPublisher;

    public Author(String id, String firstName, String lastName
            , String authorBookList, String biography,
                  String authorPublisher){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        //this.authorBookList = authorBookList;
        this.biography = biography;
        this.authorPublisher = authorPublisher;
    }

        public Author(String firstName, String lastName){
            this.firstName =firstName;
            this.lastName = lastName;
        }

        //or return full name here
        //String AuthorsFullName = firstName + lastName;

        public static String wholeAuthor(String firstName, String lastName){
            return firstName + " " + lastName;
        }

    public String getID(){
        return getID();
    }
    public void getID(String id){
        this.id = id;
    }
    public String firstName(){
        return firstName;
    }
    public void getFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getAuthorBookList(){
        return authorBookList;
    }
    public void setAuthorBookList(String authorBookList){
        this.authorBookList = authorBookList;
    }

    public String getBiography(){
        return biography;
    }
    public void setBiography(){
        this.biography =biography;
    }
    public String getAuthorPublisher(){
        return authorPublisher;
    }
    public void setAuthorPublisher(String authorPublisher){
        this.authorPublisher = authorPublisher;
    }
}
*/