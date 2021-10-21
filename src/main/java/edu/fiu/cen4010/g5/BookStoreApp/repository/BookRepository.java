package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{'isbn': ?0}")
    Optional<Book> findByISBN(String isbn);

}