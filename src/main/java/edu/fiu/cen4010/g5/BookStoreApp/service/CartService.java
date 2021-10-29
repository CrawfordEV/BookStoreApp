package edu.fiu.cen4010.g5.BookStoreApp.service;

import java.util.List;
//import java.util.Optional;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import edu.fiu.cen4010.g5.BookStoreApp.model.Cart;
import edu.fiu.cen4010.g5.BookStoreApp.repository.BookRepository;
import edu.fiu.cen4010.g5.BookStoreApp.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService{

    @Autowired
    private final CartRepository cartRepository;


    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public void addCart(String userId){

        cartRepository.findById(userId);
    }

    public void addBookToCart(String title) {
        cartRepository.findByTitle(title);
    }

    public void deleteBookFromCart(String title){
        cartRepository.deleteById(title);
    }

    public void updateCart(Cart cart){
        Cart savedCart = cartRepository.findById(cart.getId()).orElseThrow(() -> new RuntimeException(
            String.format("Cannot Find Book by ID %s", cart.getId())));
    
        savedCart.setID(cart.getId());
        savedCart.setTitle(cart.getTitle());
        cartRepository.save(savedCart);
    }

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

}