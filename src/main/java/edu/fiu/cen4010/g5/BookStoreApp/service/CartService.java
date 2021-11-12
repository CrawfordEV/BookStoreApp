package edu.fiu.cen4010.g5.BookStoreApp.service;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import edu.fiu.cen4010.g5.BookStoreApp.model.Cart;
import edu.fiu.cen4010.g5.BookStoreApp.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService{

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    // Basic CRUD operations for Cart repository

    public void addCart(Cart cart){

        Optional<Cart> repositoryResults = cartRepository.findById(cart.getId());

        if (repositoryResults.isPresent()) {
            throw new RuntimeException(String.format("Found Existing Cart with ID %s", cart.getId()));
        }
        else {
            cartRepository.insert(cart);
        }

    }

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public void updateCart(Cart cart) {

        // query the database for carts with this id
        Optional<Cart> repositoryResults = cartRepository.findById(cart.getId());

        // if no cart with this id is found, throw an error
        // use POST to create new cart, not PUT
        if (repositoryResults.isEmpty()) {
            throw new RuntimeException(String.format("Cannot find Cart with ID %s", cart.getId()));
        }

        // the database will not allow duplicate IDs in a collection, so update the only document returned
        else {
            Cart savedCart = repositoryResults.get();

            savedCart.setUserid(cart.getUserid());
            savedCart.setCart(cart.getCart());

            cartRepository.save(savedCart);
        }
    }

    public void deleteCart(String id) {
        cartRepository.deleteById(id);
    }

    // Additional operations below

    public void AddBookToCart(String cartid, String bookid) {

        // query the database for carts with this id
        Optional<Cart> repositoryResults = cartRepository.findById(cartid);

        // if no cart with this id is found, throw an error
        if (repositoryResults.isEmpty()) {
            throw new RuntimeException(String.format("Cannot find Cart with ID %s", cartid));
        }

        // TODO: validate book with id

        Cart savedCart = repositoryResults.get();

        if (savedCart.getCart().contains(bookid)) {
            throw new RuntimeException(String.format("This cart already contains Book with ID %s", bookid));
        } else {
            savedCart.getCart().add(bookid);
            cartRepository.save(savedCart);
        }
    }

    public void RemoveBookFromCart(String cartid, String bookid) {

        // query the database for carts with this id
        Optional<Cart> repositoryResults = cartRepository.findById(cartid);

        // if no cart with this id is found, throw an error
        if (repositoryResults.isEmpty()) {
            throw new RuntimeException(String.format("Cannot find Cart with ID %s", cartid));
        }

        // TODO: validate book with id

        Cart savedCart = repositoryResults.get();

        if (savedCart.getCart().contains(bookid)) {
            savedCart.getCart().remove(bookid);
            cartRepository.save(savedCart);
        } else {
            throw new RuntimeException(String.format("This cart does not contain Book with ID %s", bookid));
        }
    }

    public List<Book> getCartContents(String cartid) {

        // query the database for carts with this id
        Optional<Cart> repositoryResults = cartRepository.findById(cartid);

        // if no cart with this id is found, throw an error
        if (repositoryResults.isEmpty()) {
            throw new RuntimeException(String.format("Cannot find Cart with ID %s", cartid));
        } else {
            Cart cart = repositoryResults.get();
            ArrayList<String> bookids = cart.getCart();
            ArrayList<Book> books = new ArrayList<>();

            for (String c : bookids) {
                books.add(getBookInfo(c));
            }

            return books;
        }
    }

    private Book getBookInfo(String bookID) {

        // This path should ultimately be set based on production server installation/configuration, not hard coded
        String uri = "http://localhost:8080/api/book//byID/";
        uri += bookID;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Book.class);
    }

}
