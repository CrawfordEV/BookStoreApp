package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {

    @Query("{'id': ?0}")
    Optional<List<Author>> findByAuthorId(String id);

}
