package com.socialmedia.repository.interfaces;

import java.util.List;

public interface IUserPostsHandlingRepository {
    boolean createUserPostsMapping(String userId, String postId);

    boolean deleteUserPostsMapping(String userId, String postId);

    List<String> fetchUserToPostsMapping(String userId);

    boolean isUserHasAnyPosts(String userId);
}
