package edu.fiu.cen4010.g5.BookStoreApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("cart")
public class Cart {

    @Id
    private String id;
    @Field("userid")
    @Indexed(unique = true)
    private String userId;

//check check 123
//check 456
}
