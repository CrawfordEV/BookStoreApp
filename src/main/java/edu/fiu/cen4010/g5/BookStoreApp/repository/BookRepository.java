package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{'id': ?0}")
    Optional<Book> findByID(String id);
    @Query("{'isbn': ?0}")
    List<Book> findByISBN(String isbn);
    @Query("{'title': ?0}")
    List<Book> findByTITLE(String title);
    @Query(value ="{'description': ?0}")
    List<Book> findByDESCRIPTION(String description);
    @Query(value="{'price': ?0}")
    List<Book> findByPRICE(String price);
    @Query(value="{'author': ?0}")
    List<Book> findByAUTHOR(String author);
    @Query(value="{'genre': ?0}")
    List<Book> findByGENRE(String genre);
    @Query(value="{'bookPublisher': ?0}")
    List<Book> findByBOOKPUBLISHER(String bookPublisher);
    @Query(value="{'publishedYear': ?0}")
    List<Book> findByPUBLISHEDYEAR(String publishedYear);
    @Query(value = "{'copiesSold': ?0}")
    List<Book> findByCOPIESSOLD(String copiesSold);
}