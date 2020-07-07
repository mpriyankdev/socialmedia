package com.socialmedia.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Repository
public class UserPostsHandlingRepository implements IUserPostsHandlingRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    @Qualifier("userPostsMapping")
    private ConcurrentMap<String, List<String>> userPosts;

    @Override
    public boolean createUserPostsMapping(final String userId, final String postId) {

        LOGGER.info("Going to associate post : {} to user : {}", postId, userId);
        final List<String> postsId = new ArrayList<>();
        if (!userPosts.containsKey(userId)) {
            postsId.add(postId);
            userPosts.put(userId, postsId);

        } else {
            final List<String> ids = userPosts.get(userId);
            ids.add(postId);
            userPosts.put(userId, ids);
        }

        return true;

    }

    @Override
    public boolean deleteUserPostsMapping(final String userId, final String postId) {
        LOGGER.info("Going to de-associate post : {} to user : {}", postId, userId);

        final List<String> postsId = new ArrayList<>();
        if (userPosts.containsKey(userId)) {

            final List<String> ids = userPosts.get(userId);
            ids.remove(postId);
            userPosts.put(userId, ids);

        }

        return true;
    }

    @Override
    public List<String> fetchUserToPostsMapping(final String userId) {
        return userPosts.get(userId);
    }


    @Override
    public boolean isUserHasAnyPosts(final String userId) {

        LOGGER.info("Checking if user : {} has any posts associated with it", userId);
        if (userPosts.containsKey(userId)) {
            return userPosts.get(userId).size() >= 0;
        }
        return false;
    }

}
