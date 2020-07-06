package com.socialmedia.service.interfaces;

import com.socialmedia.model.Post;

public interface IPostsHandlingService {
    Post postCreation(String userId, String postId, String postContent);

    Post fetchPosts(String postId);
}
