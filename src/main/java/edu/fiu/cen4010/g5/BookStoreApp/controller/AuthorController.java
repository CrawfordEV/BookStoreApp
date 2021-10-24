package edu.fiu.cen4010.g5.BookStoreApp.controller;

import edu.fiu.cen4010.g5.BookStoreApp.model.Author;
import edu.fiu.cen4010.g5.BookStoreApp.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateAuthor(@RequestBody Author author) {
        authorService.updateAuthor(author);
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{fullName}")
    public ResponseEntity<Author> getAuthorByFullName(@PathVariable String fullName) {
        return ResponseEntity.ok(authorService.getAuthorByFullName(fullName));
   }

    @GetMapping("/{lastName}")
    public ResponseEntity<Author> getAuthorByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(authorService.getAuthorByLastName(lastName));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable String id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
