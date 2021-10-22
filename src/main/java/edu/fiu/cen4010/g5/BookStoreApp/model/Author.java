package edu.fiu.cen4010.g5.BookStoreApp.model;

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


}
