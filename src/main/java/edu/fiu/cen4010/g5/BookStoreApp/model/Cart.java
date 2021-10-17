package edu.fiu.cen4010.g5.BookStoreApp.model;



//import java.util.ArrayList;

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
    @Field("title") // books
    private String title;

    /////
    @Field("price")
    private String totalePrice;
    
    

    public Cart(String id, String title, String userId, String totalPrice)
    {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.totalePrice = totalPrice;
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTotalPrice()
    {
        return totalePrice;
    }

    public void setTotalPrice(String totalPrice)
    {
        this.totalePrice = totalPrice;
    }
    /////////////////
    
}
