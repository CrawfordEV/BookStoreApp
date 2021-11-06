package edu.fiu.cen4010.g5.BookStoreApp.controller;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import edu.fiu.cen4010.g5.BookStoreApp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/byISBN/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBookByISBN(isbn));
    }

    @GetMapping("/byAuthor/{author}")
    public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String authorID) {
        return ResponseEntity.ok(bookService.getBookByAuthor(authorID));
    }

    @GetMapping("/isvalid/{id}")
    public boolean validateBook(@PathVariable String id) {
        return bookService.validateBook(id);
    }

    @GetMapping("/ratinghigherthan/{value}")
    public ResponseEntity<List<Book>> getBooksWithRatingAvgHigherThan(@PathVariable float value) {
        return ResponseEntity.ok(bookService.getBooksWithAvgRatingHigherThan(value));
    }

    @GetMapping("/by/{quantity}/from/{position}")
    public ResponseEntity<List<Book>> getSubset(@PathVariable int quantity, @PathVariable int position) {
        return ResponseEntity.ok(bookService.getSubset(quantity, position));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    //problem here, I cannot have a getAuthorByFullName
    //and a getAuthorByLastName
    //it confuses the fetcher.

    //@GetMapping("/{author}")
    //public ResponseEntity<Book> getBookByAuthor(@PathVariable String author){
     //   return ResponseEntity.ok(bookService.getBookByAuthor(author));
    //}
}