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
        // TODO: validate user

        return wishlistRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find Ratings by User %s", userId)
        ));
    }

}
