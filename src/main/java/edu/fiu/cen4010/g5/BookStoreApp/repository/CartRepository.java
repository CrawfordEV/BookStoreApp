package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {

    @Query("{'id': ?0}")
    Optional<Cart> findById(String id);

    @Query("{'userid': ?0}")
    Optional<List<Cart>> findByUserId(String userid);

}
  