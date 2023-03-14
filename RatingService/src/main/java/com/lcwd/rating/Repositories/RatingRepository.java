package com.lcwd.rating.Repositories;

import com.lcwd.rating.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    // custom finder methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
