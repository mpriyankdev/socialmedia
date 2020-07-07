package com.socialmedia.repository.impl;

import com.socialmedia.model.Post;
import com.socialmedia.repository.IPostsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentMap;

@Repository
public class PostsRepository implements IPostsRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    @Qualifier("posts")
    private ConcurrentMap<String, Post> posts;

    @Override
    public Post createPost(Post post) {
        LOGGER.info("Going to create post {}", post);
        return posts.put(post.getPostId(), post);

    }

    @Override
    public boolean deletePost(String postId) {

        Post post = posts.get(postId);
        return posts.remove(postId, post);

    }

    @Override
    public Post updatePost(Post post) {
        return posts.put(post.getPostId(), post);
    }

    @Override
    public Post fetchPost(String postId) {
        return posts.getOrDefault(postId, new Post());
    }


}
