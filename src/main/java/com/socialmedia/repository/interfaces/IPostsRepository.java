package com.socialmedia.repository.interfaces;

import com.socialmedia.model.Post;

public interface IPostsRepository {
    Post createPost(Post post);

    boolean deletePost(String postId);

    Post updatePost(Post post);

    Post fetchPost(String postId);
}
