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


/*POST MAPPINGS

*/ 
    @PostMapping
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

/*PUT MAPPINGS

*/ 
    @PutMapping
    public ResponseEntity updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return ResponseEntity.ok(bookService.getAllBooks());
    }

/*GET MAPPINGS


*/ 
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("id/{id}")
    public ResponseEntity<Book> getBookByID(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getBookByID(id));
    }
    @GetMapping("description/{description}")
    public ResponseEntity<List<Book>> getBookByDESCRIPTION(@PathVariable String description) {
        return ResponseEntity.ok(bookService.getBookByDESCRIPTION(description));
    }
    @GetMapping("price/{price}")
    public ResponseEntity<List<Book>> getBookByPRICE(@PathVariable String price) {
        return ResponseEntity.ok(bookService.getBookByPRICE(price));
    }
    @GetMapping("author/{author}")
    public ResponseEntity<List<Book>> getBookByAUTHOR(@PathVariable String author) {
        return ResponseEntity.ok(bookService.getBookByAUTHOR(author));
    }
    @GetMapping("genre/{genre}")
    public ResponseEntity<List<Book>> getBookByGENRE(@PathVariable String genre) {
        return ResponseEntity.ok(bookService.getBookByGENRE(genre));
    }
    @GetMapping("bookPublisher/{bookPublisher}")
    public ResponseEntity<List<Book>> getBookByBOOKPUBLISHER(@PathVariable String bookPublisher) {
        return ResponseEntity.ok(bookService.getBookByBOOKPUBLISHER(bookPublisher));
    }
    @GetMapping("publishedYear/{publishedYear}")
    public ResponseEntity<List<Book>> getBookByPUBLISHEDYEAR(@PathVariable String publishedYear) {
        return ResponseEntity.ok(bookService.getBookByPUBLISHEDYEAR(publishedYear));
    }
    @GetMapping("copiesSold/{copiesSold}")
    public ResponseEntity<List<Book>> getBookByCOPIESSOLD(@PathVariable String copiesSold) {
        return ResponseEntity.ok(bookService.getBookByCOPIESSOLD(copiesSold));
    }
    @GetMapping("isbn/{isbn}")
    public ResponseEntity<List<Book>> getBookByISBN(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBookByISBN(isbn));
    }
    

/*DELETE MAPPINGS
    
    
    */ 
    @DeleteMapping("id/{id}")
    public ResponseEntity deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}