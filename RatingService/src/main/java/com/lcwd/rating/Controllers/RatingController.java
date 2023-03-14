package com.lcwd.rating.Controllers;

import com.lcwd.rating.Entities.Rating;
import com.lcwd.rating.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping("")
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }

    // get ratings by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByUserId(userId));
    }

    // get ratings by hotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByHotelId(hotelId));
    }

}
