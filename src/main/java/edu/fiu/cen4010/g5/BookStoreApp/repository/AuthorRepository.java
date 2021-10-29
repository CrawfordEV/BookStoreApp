package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface AuthorRepository extends MongoRepository<Author, String> {

    //@Query("{'lastName': ?0}")
    //Optional<Author>findByLastName(String lastName);
    @Query("{'fullName': ?0}")
    Optional<Author>findByFullName(String fullName);
}
