package com.socialmedia.service.impl;

import com.socialmedia.model.User;
import com.socialmedia.repository.IUsersRepository;
import com.socialmedia.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private IUsersRepository usersRepository;

    @Override
    public User createUser(User user) {
        LOGGER.info("Going to create user : {}", user);
        return usersRepository.createUser(user);

    }

    @Override
    public boolean deleteUser(String userId) {
        return usersRepository.deleteUser(userId);
    }

    @Override
    public User updateUser(User user) {
        return usersRepository.updateUser(user);
    }

    @Override
    public User fetchUser(String userId) {
        return usersRepository.fetchUser(userId);
    }

    @Override
    public boolean exists(final String userId) {
        return usersRepository.exists(userId);
    }


}
