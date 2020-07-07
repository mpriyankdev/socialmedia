package com.socialmedia.service;

import com.socialmedia.model.User;

public interface IUserService {
    User createUser(User user);

    boolean deleteUser(String userId);

    User updateUser(User user);

    User fetchUser(String userId);

    boolean exists(String userId);
}
