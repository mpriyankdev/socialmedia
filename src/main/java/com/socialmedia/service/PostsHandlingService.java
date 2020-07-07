package com.socialmedia.service;

import com.socialmedia.exception.NotFoundException;
import com.socialmedia.model.Post;
import com.socialmedia.repository.IPostsRepository;
import com.socialmedia.repository.IUserPostsHandlingRepository;
import com.socialmedia.repository.IUsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class PostsHandlingService implements IPostsHandlingService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private IPostsRepository postsRepository;

    @Autowired
    private IUserPostsHandlingRepository userPostsHandlingRepository;


    @Override
    public Post postCreation(final String userId, final String postId, final String postContent) {
        /**
         check if user exists
         form post
         create post and return if successfully created
         */
        if (!isUserExists(userId)) {
            throw new NotFoundException("user not present with id :" + userId);
        }
        LOGGER.info("Going to create post posted by userId : {}", userId);
        final Post post = createPost(postId, postContent);
        postsRepository.createPost(post);
        userPostsHandlingRepository.createUserPostsMapping(userId, postId);

        return (post == null) ? Post.builder().build() : post;


    }

    @Override
    public Post fetchPosts(final String postId) {
        return postsRepository.fetchPost(postId);
    }

    private boolean isUserExists(final String userId) {
        return usersRepository.exists(userId);
    }

    private Post createPost(final String postId, final String postContent) {
        return Post.builder().postId(postId).postTime(OffsetDateTime.now()).content(postContent).build();
    }

}
