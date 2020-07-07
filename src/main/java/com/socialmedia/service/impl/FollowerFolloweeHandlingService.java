package com.socialmedia.service.impl;

import com.socialmedia.repository.IFollowerFolloweeHandlingRepository;
import com.socialmedia.repository.IUserPostsHandlingRepository;
import com.socialmedia.service.IFollowerFolloweeHandlingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FollowerFolloweeHandlingService implements IFollowerFolloweeHandlingService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private IFollowerFolloweeHandlingRepository followerFolloweeHandlingRepository;

    @Autowired
    private IUserPostsHandlingRepository userPostsHandlingRepository;

    @Override
    public boolean follow(final String followerId, final String followeeId) {

        LOGGER.info("Follower : {} is following : {}", followerId, followeeId);
        return followerFolloweeHandlingRepository.follow(followerId, followeeId);

    }

    @Override
    public boolean unfollow(final String followerId, final String followeeId) {

        LOGGER.info("Follower : {} is unfollowing : {}", followerId, followeeId);
        return followerFolloweeHandlingRepository.unfollow(followerId, followeeId);
    }

    @Override
    public Set<String> followees(final String userId) {
        return followerFolloweeHandlingRepository.followees(userId);
    }


}
