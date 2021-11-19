package edu.fiu.cen4010.g5.BookStoreApp.service;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import edu.fiu.cen4010.g5.BookStoreApp.model.Wishlist;
import edu.fiu.cen4010.g5.BookStoreApp.repository.WishlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {
    
    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    // Basic CRUD operations for Wishlist repository

    public void addWishlist(Wishlist wishlist){

        Optional<Wishlist> repositoryResults = wishlistRepository.findById(wishlist.getId());

        if (repositoryResults.isPresent()) {
            throw new RuntimeException(String.format("Found Existing Wishlist with ID %s", wishlist.getId()));
        }
        else {
            wishlistRepository.insert(wishlist);
        }

    }

    public List<Wishlist> getAllWishlists(){
        return wishlistRepository.findAll();
    }

    public void updateWishlist(Wishlist wishlist) {

        // query the database for wishlists with this id
        Optional<Wishlist> repositoryResults = wishlistRepository.findById(wishlist.getId());

        // if no wishlist with this id is found, throw an error
        // use POST to create new cart, not PUT
        if (repositoryResults.isEmpty()) {
            throw new RuntimeException(String.format("Cannot find Wishlist with ID %s", wishlist.getId()));
        }

        // the database will not allow duplicate IDs in a collection, so update the only document returned
        else {
            Wishlist savedWishlist = repositoryResults.get();

            savedWishlist.setUserid(wishlist.getUserid());
            savedWishlist.setBooks(wishlist.getBooks());
            savedWishlist.setWishlistName(wishlist.getWishlistName());

            wishlistRepository.save(savedWishlist);
        }
    }

    public void deleteWishlist(String id) {
        wishlistRepository.deleteById(id);
    }

    public void AddBookToWishlist(String wishlistid, String bookid) {

        // query the database for wishlists with this id
        Optional<Wishlist> repositoryResults = wishlistRepository.findById(wishlistid);

        // if no wishlist with this id is found, throw an error
        if (repositoryResults.isEmpty()) {
            throw new RuntimeException(String.format("Cannot find Wishlist with ID %s", wishlistid));
        }

        // TODO: validate book with id

        Wishlist savedWishlist = repositoryResults.get();
        ArrayList<String> booksInWishlist = savedWishlist.getBooks();

        if (booksInWishlist == null) {
            booksInWishlist = new ArrayList<String>();
        }

        // the wishlist is empty, so add the book and save
        if (booksInWishlist.isEmpty()) {
            booksInWishlist.add(bookid);
            savedWishlist.setBooks(booksInWishlist);
            wishlistRepository.save(savedWishlist);
        }

        // the wishlist is not empty, so check to see if the book is already in the cart before adding
        else {
            if (!booksInWishlist.contains(bookid)) {
                booksInWishlist.add(bookid);
                savedWishlist.setBooks(booksInWishlist);
                wishlistRepository.save(savedWishlist);
            }
        }
    }
    
    //Remove book from wishlist

    public void RemoveBookFromWishlist(String wishlistid, String bookid) {

        // query the database for wishlists with this id
        Optional<Wishlist> repositoryResults = wishlistRepository.findById(wishlistid);

        // if no wishlist with this id is found, throw an error
        if (repositoryResults.isEmpty()) {
            throw new RuntimeException(String.format("Cannot find Wishlist with ID %s", wishlistid));
        }

        // TODO: validate book with id

        Wishlist savedWishlist = repositoryResults.get();
        ArrayList<String> booksInWishlist = savedWishlist.getBooks();

        if (booksInWishlist == null) {
            booksInWishlist = new ArrayList<String>();
            savedWishlist.setBooks(booksInWishlist);
            wishlistRepository.save(savedWishlist);
        }

        // if the cart is not empty, remove the book
        if (!booksInWishlist.isEmpty()) {
            booksInWishlist.remove(bookid);
            savedWishlist.setBooks(booksInWishlist);
            wishlistRepository.save(savedWishlist);
        }
    }

    public List<Book> getWishlistContents(String wishlistid) {

        // query the database for wishlists with this id
        Optional<Wishlist> repositoryResults = wishlistRepository.findById(wishlistid);

        // if no wishlist with this id is found, throw an error
        if (repositoryResults.isEmpty()) {
            throw new RuntimeException(String.format("Cannot find Wishlist with ID %s", wishlistid));
        }

        else {
            Wishlist wishlist = repositoryResults.get();
            ArrayList<String> booksInWishlist = wishlist.getBooks();

            if (booksInWishlist == null) {
                booksInWishlist = new ArrayList<String>();
                wishlist.setBooks(booksInWishlist);
                wishlistRepository.save(wishlist);
            }

            ArrayList<Book> books = new ArrayList<>();

            if (!booksInWishlist.isEmpty()) {
                for (String c : booksInWishlist) {
                    books.add(getBookInfo(c));
                }
            }

            return books;
        }
    }

    private Book getBookInfo(String bookID) {

        // This path should ultimately be set based on production server installation/configuration, not hard coded
        String uri = "http://localhost:8080/api/book/byID/";
        uri += bookID;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Book.class);
    }

    /**

    public void addBook(Wishlist book) {
        wishlistRepository.insert(book);
    }

    public List<Wishlist> getAllBooks() {
        return wishlistRepository.findAll();
    }

    public List<Wishlist> getWishlistByUser(String userId) {

        return wishlistRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find user %s", userId)
        ));
    }

    public List<Wishlist> getWishlistByWishlistName(String wishlistName) {

        return wishlistRepository.findByWishlistName(wishlistName).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find wishlist %s", wishlistName)
        ));
    }

    public void pushBookToCart(String wishlistID, String cartID, String bookID) {

        String uri = "http://localhost:8080/api/cart/" + cartID + "/addBook" + bookID;

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(uri, String.class);

        // remove book from wishlist after successful
    }
    */
}
