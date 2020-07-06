package com.socialmedia.service.interfaces;

import com.socialmedia.model.Post;

import java.util.List;

public interface INewsFeedHandlingService {
    List<Post> topNPosts(String userId, Integer numberOfPosts);
}
