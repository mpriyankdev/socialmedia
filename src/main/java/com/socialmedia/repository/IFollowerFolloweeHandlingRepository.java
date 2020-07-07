package com.socialmedia.repository;

import java.util.Set;

public interface IFollowerFolloweeHandlingRepository {
    boolean follow(String followerId, String followeeId);

    boolean unfollow(String followerId, String followeeId);

    Set<String> followees(String followeeId);
}
