package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{'id': ?0}")
    Optional<List<User>> findByUserId(String id);

    @Query("{'email': ?0}")
    Optional<List<User>> findByEmail(String email);

}