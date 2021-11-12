package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    @Query("{'id': ?0}")
    Optional<Rating> findById(String id);

    @Query("{'userid': ?0}")
    Optional<List<Rating>> findByUserId(String userid);

    @Query("{'bookid': ?0}")
    Optional<List<Rating>> findByBookId(String bookid);

}