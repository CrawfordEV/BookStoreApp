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

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBookByISBN(isbn));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
/*
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
    public ResponseEntity <List<Book>> getAllBooks()
    {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity <List<Book>> getBookByID(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getBookByID(id));
    }
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity <List<Book>> getBookByISBN(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBookByISBN(isbn));
    }
    @GetMapping("/title/{title}")
    public ResponseEntity <List<Book>> getBooksByTITLE(@PathVariable String title) {
        return ResponseEntity.ok(bookService.getBooksByTITLE(title));
    }
    @GetMapping("/description/{description}")
    public ResponseEntity <List<Book>> getBookByDESCRIPTION(@PathVariable String description) {
        return ResponseEntity.ok(bookService.getBookByDESCRIPTION(description));
    }
    @GetMapping("/price/{price}")
    public ResponseEntity<List<Book>> getBooksByPRICE(@PathVariable double price) {
        return ResponseEntity.ok(bookService.getBooksByPRICE(price));
    }
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAUTHOR(@PathVariable String author) {
        return ResponseEntity.ok(bookService.getBooksByAUTHOR(author));
    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity <List<Book>> getBookByGENRE(@PathVariable String genre) {
        return ResponseEntity.ok(bookService.getBooksByGENRE(genre));
    }
    @GetMapping("/bookPublisher/{bookPublisher}")
    public ResponseEntity <List<Book>> getBookByBOOKPUBLISHER(@PathVariable String bookPublisher) {
        return ResponseEntity.ok(bookService.getBooksByBOOKPUBLISHER(bookPublisher));
    }
    @GetMapping("/publishedYear/{publishedYear}")
    public ResponseEntity <List<Book>> getBooksByPUBLISHEDYEAR(@PathVariable int publishedYear) {
        return ResponseEntity.ok(bookService.getBooksByPUBLISHEDYEAR(publishedYear));
    }
    @GetMapping("/copiesSold/{copiesSold}")
    public ResponseEntity <List<Book>> getBookByCOPIESSOLD(@PathVariable int copiesSold) {
        return ResponseEntity.ok(bookService.getBooksByCOPIESSOLD(copiesSold));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}*/
