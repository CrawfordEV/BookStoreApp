package edu.fiu.cen4010.g5.BookStoreApp.controller;

import edu.fiu.cen4010.g5.BookStoreApp.model.Wishlist;
import edu.fiu.cen4010.g5.BookStoreApp.service.WishlistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
    
    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistservice){
        this.wishlistService = wishlistservice;
    }

    @PostMapping
    public ResponseEntity addBook(@RequestBody Wishlist book) {
        wishlistService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Wishlist>> getAllBooks() {
        return ResponseEntity.ok(wishlistService.getAllBooks());
    }

    @GetMapping("/byuser/{userid}")
    public ResponseEntity<List<Wishlist>> getWishlistByUser(@PathVariable String userid) {
        return ResponseEntity.ok(wishlistService.getWishlistByUser(userid));
    }

    @GetMapping("/bywishlistname/{wishlistName}")
    public ResponseEntity<List<Wishlist>> getWishlistByWishlistName(@PathVariable String wishlistName) {
        return ResponseEntity.ok(wishlistService.getWishlistByWishlistName(wishlistName));
    }

    /**
    @PutMapping
    public ResponseEntity updateWishlistName(@RequestBody Wishlist wishlistName) {
        wishlistService.updateWishlistName(wishlistName);
        return ResponseEntity.ok(WishlistService.getAllWishlistName());
    }
    */
}
