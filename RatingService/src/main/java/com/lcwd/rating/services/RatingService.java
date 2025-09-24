package com.lcwd.rating.services;

import com.lcwd.rating.entities.Rating;

import java.util.List;

public interface RatingService {
    // create
    Rating create(Rating rating);

    // get all ratings
    List<Rating> getAllRatings();

    // get all ratings by userId
    List<Rating> getRatingsByUserId(String userId);

    // get all ratings by hotelId
    List<Rating> getRatingsByHotelId(String hotelId);

    // get single rating by ratingId
    Rating getRating(String ratingId);

}
