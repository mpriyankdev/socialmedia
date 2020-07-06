package com.socialmedia.repository.interfaces;

import com.socialmedia.model.User;

public interface IUsersRepository {
    User createUser(User user);

    boolean deleteUser(String userId);

    User updateUser(User user);

    User fetchUser(String userId);

    boolean exists(String userId);
}
