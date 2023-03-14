package com.lcwd.user.service.Services.impl;

import com.lcwd.user.service.Entities.Hotel;
import com.lcwd.user.service.Entities.Rating;
import com.lcwd.user.service.Entities.User;
import com.lcwd.user.service.External.Service.HotelService;
import com.lcwd.user.service.External.Service.RatingService;
import com.lcwd.user.service.Repositories.UserRepository;
import com.lcwd.user.service.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
        // generate unique userid
        String randomUserid = UUID.randomUUID().toString();
        user.setUserId(randomUserid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with given Id is not found in server."));

        //find the list of ratings by calling api  http://localhost:8083/ratings/users/userId
        // This has been changed and used feign client
        List<Rating> ratings = ratingService.getRatingByUserId(userId);
        List<Rating> ratingList = ratings.stream().map(rating -> {
            // find hotel rating by calling api http://localhost:8082/hotels/{hotelId}
            // This has been changed and used feign client
            Hotel hotel = hotelService.getHotelById(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).toList();
        user.setRatings(ratingList);
        return user;
    }
}
