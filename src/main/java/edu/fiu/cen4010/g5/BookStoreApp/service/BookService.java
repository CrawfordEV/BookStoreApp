package edu.fiu.cen4010.g5.BookStoreApp.service;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import edu.fiu.cen4010.g5.BookStoreApp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.insert(book);
    }

    public void updateBook(Book book) {
        Book savedBook = bookRepository.findById(book.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Book by ID %s", book.getId())
                ));

        savedBook.setISBN(book.getISBN());
        savedBook.setTitle(book.getTitle());
        savedBook.setGenre(book.getGenre());

        bookRepository.save(savedBook);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByISBN(String isbn) {
        return bookRepository.findByISBN(isbn).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find Book by ISBN %s", isbn)
        ));
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

}
