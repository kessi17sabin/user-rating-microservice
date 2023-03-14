package com.lcwd.rating.Services;

import com.lcwd.rating.Entities.Rating;

import java.util.List;

public interface RatingService {

    // create
    Rating create(Rating rating);

    // get all ratings
    List<Rating> getAllRatings();

    // get all by UserId
    List<Rating> getRatingsByUserId(String userId);

    // get all by Hotel
    List<Rating> getRatingsByHotelId(String hotelId);
}
