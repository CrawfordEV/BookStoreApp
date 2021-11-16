package edu.fiu.cen4010.g5.BookStoreApp.service;

import edu.fiu.cen4010.g5.BookStoreApp.model.Wishlist;
import edu.fiu.cen4010.g5.BookStoreApp.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    
    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

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

}
