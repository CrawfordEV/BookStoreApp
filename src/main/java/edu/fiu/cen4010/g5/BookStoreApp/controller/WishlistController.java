package edu.fiu.cen4010.g5.BookStoreApp.controller;

import edu.fiu.cen4010.g5.BookStoreApp.model.Book;
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

    // CRUD operations for Wishlists
    
    //Adds wishlist
    @PostMapping
    public ResponseEntity addWishlist(@RequestBody Wishlist wishlist){
        wishlistService.addWishlist(wishlist);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Read/Get Wishlist
    @GetMapping
    public ResponseEntity<List<Wishlist>> getAllWishlists(){
        return ResponseEntity.ok(wishlistService.getAllWishlists());
    }

    //Update/Put Wishlist
    @PutMapping
    public ResponseEntity updateWishlist(@RequestBody Wishlist wishlist) {
        wishlistService.updateWishlist(wishlist);
        return ResponseEntity.ok(wishlistService.getAllWishlists());
    }

    //Delete Wishlist
    @DeleteMapping("/{id}")
    public ResponseEntity deleteWishlist(@PathVariable String id) {
        wishlistService.deleteWishlist(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Extended functionality to add/remove books and display wishlist contents

    @GetMapping("/{wishlistid}")
    public ResponseEntity<List<Book>> getWishlistContents(@PathVariable String wishlistid){
        return ResponseEntity.ok(wishlistService.getWishlistContents(wishlistid));
    }

    @PutMapping("/{wishlistid}/addBook/{bookid}")
    public ResponseEntity addBookToWishlist(@PathVariable String wishlistid, @PathVariable String bookid) {
        wishlistService.AddBookToWishlist(wishlistid, bookid);
        return ResponseEntity.ok(wishlistService.getWishlistContents(wishlistid));
    }

    @PutMapping("/{wishlistid}/removeBook/{bookid}")
    public ResponseEntity removeBookFromWishlist(@PathVariable String wishlistid, @PathVariable String bookid) {
        wishlistService.RemoveBookFromWishlist(wishlistid, bookid);
        return ResponseEntity.ok(wishlistService.getWishlistContents(wishlistid));
    }

    @PutMapping("/{wishlistid}/pushBook/{bookid}/toCart/{cartid}")
    public ResponseEntity pushBookToCart(@PathVariable String wishlistid, @PathVariable String bookid, @PathVariable String cartid) {
        wishlistService.pushBookToCart(wishlistid, bookid, cartid);
        return ResponseEntity.ok(wishlistService.getWishlistContents(wishlistid));
    }

}
