package com.lcwd.user.service.Controller;

import com.lcwd.user.service.Entities.User;
import com.lcwd.user.service.Services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    // create
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    int retryCount = 1;
    // single user get
    @GetMapping("/{userId}")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        logger.info("retry count {}", retryCount);
        retryCount ++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception exception) {
        logger.info("Fallback is executed because service is down: ", exception.getMessage());
        User user = User.builder().name("Dummy")
                .email("dummy@gmail.com")
                .about("This user is created dummy because some service is down")
                .userId("123456abc")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // all user get
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }
}
