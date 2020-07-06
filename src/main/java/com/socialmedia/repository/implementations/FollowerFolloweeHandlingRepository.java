package com.socialmedia.repository.implementations;

import com.socialmedia.repository.interfaces.IFollowerFolloweeHandlingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

@Repository
public class FollowerFolloweeHandlingRepository implements IFollowerFolloweeHandlingRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    @Qualifier("followerFollowee")
    private ConcurrentMap<String, Set<String>> followerFollowee;

    @Override
    public boolean follow(final String followerId, final String followeeId) {

        if (followerFollowee.containsKey(followerId)) {
            final Set<String> allFollowers = followerFollowee.get(followerId);
            allFollowers.add(followeeId);
            allFollowers.add(followerId);
            followerFollowee.put(followerId, allFollowers);
        } else {
            final Set<String> allFollowers = new HashSet<>();
            allFollowers.add(followerId);
            allFollowers.add(followeeId);
            followerFollowee.put(followerId, allFollowers);
        }

        return true;


    }

    @Override
    public boolean unfollow(final String followerId, final String followeeId) {

        if (followerFollowee.containsKey(followerId)) {
            final Set<String> allFollowers = followerFollowee.get(followerId);
            allFollowers.remove(followeeId);
            followerFollowee.put(followerId, allFollowers);
        }

        return true;

    }

    @Override
    public Set<String> followees(final String followeeId) {
        Set<String> defaultSet = new HashSet<>();
        defaultSet.add(followeeId); //for following itself
        return followerFollowee.getOrDefault(followeeId, defaultSet);
    }
}
