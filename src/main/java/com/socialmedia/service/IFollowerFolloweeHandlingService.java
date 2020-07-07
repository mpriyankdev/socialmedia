package com.socialmedia.service;

import java.util.Set;

public interface IFollowerFolloweeHandlingService {
    boolean follow(String followerId, String followeeId);

    boolean unfollow(String followerId, String followeeId);

    Set<String> followees(String userId);
}
