package edu.fiu.cen4010.g5.BookStoreApp.service;

import edu.fiu.cen4010.g5.BookStoreApp.model.Rating;
import edu.fiu.cen4010.g5.BookStoreApp.model.RatingSortedByValueAsc;
import edu.fiu.cen4010.g5.BookStoreApp.model.RatingSortedByValueDes;
import edu.fiu.cen4010.g5.BookStoreApp.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void addRating(Rating rating) {

        // TODO: Validate user and book from other features (dependencies)

        // validate the value passed for the rating (1-5 stars)
        int v = rating.getValue();
        if (v > 5 || v < 1) {
            throw new RuntimeException(String.format("Invalid value. Ratings must be between 1-5."));
        }

        // get a list of all ratings in the database by this user
        Optional<List<Rating>> repositoryResults = ratingRepository.findByUserId(rating.getUserid());

        // if no ratings already exist for this user, go ahead and add the new rating (user/book were validated earlier)
        if (repositoryResults.isPresent() == false) {
            ratingRepository.insert(rating);
        }

        // some ratings do exist by this user
        else {

            // check that there is not already an existing rating by this user for the specified book
            List<Rating> queryResultsForUser = repositoryResults.get();
            List<Rating> queryResultsForUserAndBook = new ArrayList<>();
            for (Rating r : queryResultsForUser) {
                if (r.getBookid().equals(rating.getBookid())) {
                    queryResultsForUserAndBook.add(r);
                }
            }

            // no rating by this user for this book, so insert it
            if (queryResultsForUserAndBook.size() == 0) {
                ratingRepository.insert(rating);
            }

            // rating for this book by this user already exists, so throw error
            // PUT API should be used to update instead of insert
            else {
                throw new RuntimeException(String.format("Found Existing Rating for Book ID %s by User ID %s", rating.getBookid(), rating.getUserid()));
            }
        }
    }

    public void updateRating(Rating rating) {

//        TODO: Validate user and book from other features (dependencies)

        // validate the value passed for the rating (1-5 stars)
        int v = rating.getValue();
        if (v > 5 || v < 1) {
            throw new RuntimeException(String.format("Invalid value. Ratings must be between 1-5."));
        }

        // get a list of all ratings in the database by this user
        Optional<List<Rating>> repositoryResults = ratingRepository.findByUserId(rating.getUserid());

        // if no ratings by this user exist, we cannot update one so throw an error
        // POST API should be used to insert new ratings instead of update
        if (repositoryResults.isPresent() == false) {
            throw new RuntimeException(String.format("Cannot find Ratings by User %s", rating.getUserid()));
        }

        // some ratings by this user exist, so find the one for the specified book if it exists
        else {
            List<Rating> queryResultsForUser = repositoryResults.get();
            List<Rating> queryResultsForUserAndBook = new ArrayList<>();
            for (Rating r : queryResultsForUser) {
                if (r.getBookid().equals(rating.getBookid())) {
                    queryResultsForUserAndBook.add(r);
                }
            }

            // could not find a rating for the specified book by this user, so throw an error
            // POST API should be used to insert new ratings instead of update
            if (queryResultsForUserAndBook.size() == 0) {
                throw new RuntimeException(String.format("Cannot Find Rating for Book ID %s by User ID %s", rating.getBookid(), rating.getUserid()));
            }

            // for some reason, multiple ratings for the specified book by this user were found, so throw an error
            // only one rating should exist per user per book
            else if (queryResultsForUserAndBook.size() > 1) {
                throw new RuntimeException(String.format("Found Duplicate Ratings for Book ID %s by User ID %s", rating.getBookid(), rating.getUserid()));
            }

            // only one rating by this user for the specified book exists, so update it
            else {
                Rating savedRating = queryResultsForUserAndBook.get(0);

                savedRating.setUserid(rating.getUserid());
                savedRating.setBookid(rating.getBookid());
                savedRating.setDate(rating.getDate());
                savedRating.setValue(rating.getValue());
                savedRating.setComment(rating.getComment());

                ratingRepository.save(savedRating);
            }
        }

//        Rating savedRating = ratingRepository.findByUserIdAndBookId(rating.getUserid(), rating.getBookid())
//                .orElseThrow(() -> new RuntimeException(
//                        String.format("Cannot Find Rating for Book ID %s by User ID %s", rating.getBookid(), rating.getUserid())
//                ));

    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingsByUser(String userId) {
        // TODO: validate user

        return ratingRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find Ratings by User %s", userId)
        ));
    }

    public List<Rating> getRatingsByBook(String bookId) {
        // TODO: validate book

        return ratingRepository.findByBookId(bookId).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find Ratings for Book %s", bookId)
        ));
    }

    public List<Rating> getRatingsByBookSortedDes(String bookid) {
        // validation of book and existence of results performed in getRatingsByBook method

        List<Rating> unsortedRatings = getRatingsByBook(bookid);
        unsortedRatings.sort(new RatingSortedByValueDes());

        return unsortedRatings;
    }

    public List<Rating> getRatingsByBookSortedAsc(String bookid) {
        // validation of book and existence of results performed in getRatingsByBook method

        List<Rating> unsortedRatings = getRatingsByBook(bookid);
        unsortedRatings.sort(new RatingSortedByValueAsc());

        return unsortedRatings;
    }

    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    public float getAverageRating(String bookid) {
        // validation of bookid done in getRatingsByBook method

        List<Rating> allRatingsByBook = getRatingsByBook(bookid);
        long sum = 0;

        for (Rating r : allRatingsByBook) {
            sum += r.getValue();
        }

        return sum / (float) allRatingsByBook.size();
    }

}
