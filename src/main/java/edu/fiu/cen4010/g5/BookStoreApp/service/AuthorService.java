package edu.fiu.cen4010.g5.BookStoreApp.service;

import edu.fiu.cen4010.g5.BookStoreApp.model.Author;
import edu.fiu.cen4010.g5.BookStoreApp.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(Author author) {
        authorRepository.insert(author);
    }

    public void updateAuthor(Author author) {
        Author savedAuthor = authorRepository.findById(author.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Author by ID %s", author.getId())
                ));

        savedAuthor.setFirstName(author.getFirstName());
        savedAuthor.setLastName(author.getLastName());
        savedAuthor.setBiography(author.getBiography());
        savedAuthor.setPublisher(author.getPublisher());
        savedAuthor.setFullName(author.getFullName());
        authorRepository.save(savedAuthor);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


    public Author getAuthorByFullName(String fullName) {
        return authorRepository.findByFullName(fullName).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find Author by ID %s", fullName)
        ));
    }

    public Author getAuthorByLastName(String lastName) {
        return authorRepository.findByLastName(lastName).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find the Author's last name %s", lastName)
        ));
    }
    public void deleteAuthor(String id) {
        authorRepository.deleteById(id);
    }

}