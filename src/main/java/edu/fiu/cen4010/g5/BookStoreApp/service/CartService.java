package edu.fiu.cen4010.g5.BookStoreApp.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import edu.fiu.cen4010.g5.BookStoreApp.model.Cart;
import edu.fiu.cen4010.g5.BookStoreApp.repository.BookRepository;
import edu.fiu.cen4010.g5.BookStoreApp.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService{

    @Autowired
    private final CartRepository cartRepository;

    // @Autowired
  //  private final BookRepository bookRepository;


    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

   
    

    public void addCart(String id){
        cartRepository.findById(id);
    }

    public List<Book> getAllBooks() {

        String auri = "http://localhost:8080/api/book/";
        

        RestTemplate restTemplate2 = new RestTemplate();
        return RestTemplate.getForObject(auri, List<Book>);
        

    }

    public List<Book> addBooks(String bookId, String cartId) {

        List<Book> allBooks = getAllBooks();

        // this is the list of all books where the average rating was higher than the value passed as a parameter
        List<Book> bookMatches = new ArrayList<Book>();

        for (Book book : allBooks) {
            if (getBookInfo(book.getId()) == bookId) {
                bookMatches.add(book);
            }
        }

        return bookMatches;
    }


    private String getBookInfo(String bookId) {

        // This path should ultimately be set based on production server installation/configuration, not hard coded
        String uri = "http://localhost:8080/api/book/";
        uri += bookId;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }

    

    /*
    public void createCart(String userId) {
        Cart cart = new Cart(userId, new ArrayList<Cart???orBook??>());
        cartRepository.insert(cart);
    }
    */
   
    
    public void updateCart(Cart cart){
        Cart savedCart = cartRepository.findById(cart.getId()).orElseThrow(() -> new RuntimeException(
            String.format("Cannot Find Book by ID %s", cart.getId())));
    
        savedCart.setID(cart.getId());
        

        cartRepository.save(savedCart);
    }

       
    public void updateCart(Cart cart, String bookID){
        Cart savedCart = cartRepository.findById(cart.getId()).orElseThrow(() -> new RuntimeException(
            String.format("Cannot Find Book by ID %s", cart.getId())));
    
        savedCart.setID(cart.getId());
        savedCart.getCart().add(getBookInfo(bookID));

        cartRepository.save(savedCart);
    }
    

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public List<Cart> getRatingsByUser(String userId) {
        return cartRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find Ratings by User %s", userId)
        ));
    }

    public void createCart(String id) {
    }

    public void removeBookfromCart(String userId, String bookId) {
    }

    public Object getCartBooksByUser(String userId) {
        return null;
    }
}
