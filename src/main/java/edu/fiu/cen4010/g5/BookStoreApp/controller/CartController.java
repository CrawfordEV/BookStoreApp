package edu.fiu.cen4010.g5.BookStoreApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
import edu.fiu.cen4010.g5.BookStoreApp.model.Cart;

import edu.fiu.cen4010.g5.BookStoreApp.model.User;
import edu.fiu.cen4010.g5.BookStoreApp.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    
    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    
    @PostMapping("/cart/{id}")
    public ResponseEntity addCart(@RequestBody String id){
        cartService.addCart(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /*
    @PostMapping
    public ResponseEntity createCart(@RequestBody User user) {
        cartService.createCart(user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
*/
     


/*
    @PostMapping("/cart/{title}")
    public ResponseEntity addBookToCart(@PathVariable String title){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
/*
    @DeleteMapping("/cart/{title}")
    public ResponseEntity deleteBookFromCart(@PathVariable String title){
        cartService.deleteBookFromCart(title);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
*/
    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }

   
    @PutMapping("/cart/{cartID}/add/{bookID}")
    public ResponseEntity updateCart(@RequestBody Cart cart, @PathVariable String bookID){
        cartService.updateCart(cart);
        return ResponseEntity.ok(cartService.getAllCarts());
    }
   
}