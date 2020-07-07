package com.socialmedia.service;

import com.socialmedia.model.Post;

import java.util.List;

public interface INewsFeedHandlingService {
    List<Post> topNPosts(String userId, Integer numberOfPosts);
}
