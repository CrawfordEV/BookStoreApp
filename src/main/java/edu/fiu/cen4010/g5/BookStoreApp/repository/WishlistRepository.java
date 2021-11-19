package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends MongoRepository<Wishlist, String> {

    @Query("{'id': ?0}")
    Optional<Wishlist> findById(String id);

    @Query("{'userid': ?0}")
    Optional<List<Wishlist>> findByUserId(String userid);

    @Query("{'wishlist name': ?0}")
    Optional<List<Wishlist>> findByWishlistName(String wishlistName);

}
