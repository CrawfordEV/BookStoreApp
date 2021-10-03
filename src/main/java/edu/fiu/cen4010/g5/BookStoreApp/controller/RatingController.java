package edu.fiu.cen4010.g5.BookStoreApp.controller;

import edu.fiu.cen4010.g5.BookStoreApp.model.Rating;
import edu.fiu.cen4010.g5.BookStoreApp.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity addRating(@RequestBody Rating rating) {
        ratingService.addRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateRating(@RequestBody Rating rating) {
        ratingService.updateRating(rating);
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/byuser/{userid}")
    public ResponseEntity<List<Rating>> getRatingsByUser(@PathVariable String userid) {
        return ResponseEntity.ok(ratingService.getRatingsByUser(userid));
    }

    @GetMapping("/bybook/{bookid}")
    public ResponseEntity<List<Rating>> getRatingsByBook(@PathVariable String bookid) {
        return ResponseEntity.ok(ratingService.getRatingsByBook(bookid));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRating(@PathVariable String id) {
        ratingService.deleteRating(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
