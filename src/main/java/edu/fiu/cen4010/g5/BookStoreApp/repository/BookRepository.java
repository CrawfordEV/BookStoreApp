package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    

    @Query(value="{ 'isbn' : ?0 }")
    List<Book> findByISBN(String isbn);
    @Query(value="{ 'id' : ?0 }")
    List<Book> findByID(String id);
    @Query(value="{ 'genre' : ?0 }")
    List<Book> findByGENRE(String genre);
    


    public long count();
}
