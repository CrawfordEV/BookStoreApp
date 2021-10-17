package edu.fiu.cen4010.g5.BookStoreApp.repository;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {


    @Query(value="{ 'id' : ?0 }")
    List<Book> findByID(String id);
    @Query(value="{ 'isbn' : ?0 }")
    List<Book> findByISBN(String isbn);
    //my work
    @Query(value="{ 'title' : ?0 }")
    List<Book> findByTITLE(String title);
    @Query(value ="{'description : ?0 }")
    List<Book> findByDESCRIPTION(String description);
    @Query(value="{ 'price' : ?0 }")
    List<Book> findByPRICE(double price);
    @Query(value="{ 'author' : ?0 }")
    List<Book> findByAUTHOR(String author);
    @Query(value="{ 'genre' : ?0 }")
    List<Book> findByGENRE(String genre);
    @Query(value="{ 'bookPublisher' : ?0 }")
    List<Book> findByBOOKPUBLISHER(String bookPublisher);
    @Query(value="{ 'publishedYear' : ?0 }")
    List<Book> findByPUBLISHEDYEAR(int publishedYear);
    @Query(value = "{'copiesSold' : ?0 }")
    List<Book> findByCOPIESSOLD(int copiesSold);
    //@Query(value = "{'copiesSold' : ?0 }")
    //List<Book> findByCOPIESSOLD(int copiesSold);
    //@Query(value="{ 'PRICE' : ?0 }")
    //List<Book> findByPRICE(String Price);

    public long count();//what is this?
}