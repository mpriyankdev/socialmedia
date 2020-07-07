package com.socialmedia.repository.impl;

import com.socialmedia.model.User;
import com.socialmedia.repository.IUsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentMap;

@Repository
public class UsersRepository implements IUsersRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    @Qualifier("users")
    private ConcurrentMap<String, User> users;

    @Override
    public User createUser(User user) {
        LOGGER.info("Creating user : {}", user);
        return users.put(user.getUserId(), user);

    }

    @Override
    public boolean deleteUser(String userId) {

        User user = users.get(userId);

        final boolean remove = users.remove(userId, user);
        LOGGER.info("Deleting user with id : {} = {}", user, remove);

        return remove;
        
    }

    @Override
    public User updateUser(User user) {
        LOGGER.info("Updating user : {}", user);
        return users.put(user.getUserId(), user);
    }

    @Override
    public User fetchUser(String userId) {

        final User orDefault = users.getOrDefault(userId, new User());
        LOGGER.info("Fetched user with id : {} = {}", userId, orDefault);
        return orDefault;
    }

    @Override
    public boolean exists(final String userId) {

        final boolean existence = users.containsKey(userId);
        LOGGER.info("User exists with id : {} = {}", userId, existence);
        return existence;

    }

}
