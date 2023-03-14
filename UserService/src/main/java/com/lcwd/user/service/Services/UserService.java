package com.lcwd.user.service.Services;

import com.lcwd.user.service.Entities.User;

import java.util.List;

public interface UserService {

    // user operations

    // create user
    User saveUser(User user);

    // get all user
    List<User> getAllUser();

    // get single user by given userId
    User getUser(String userId);

    // todo: delete
    // todo: update

}
