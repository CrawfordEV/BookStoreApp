package edu.fiu.cen4010.g5.BookStoreApp.model;

import java.util.Comparator;

public class RatingSortedByValueAsc implements Comparator<Rating> {

    @Override
    public int compare(Rating r1, Rating r2) {
        return r1.getValue() - r2.getValue();
    }
}
