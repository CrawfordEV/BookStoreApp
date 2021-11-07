package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{'id': ?0}")
    Optional<List<Book>> findByBookId(String id);

    @Query("{'isbn': ?0}")
    Optional<List<Book>> findByISBN(String isbn);

}
