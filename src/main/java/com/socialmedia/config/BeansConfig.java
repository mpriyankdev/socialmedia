package com.socialmedia.config;

import com.socialmedia.model.Post;
import com.socialmedia.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Configuration
public class BeansConfig {

    @Bean(name = "users")
    public ConcurrentMap<String, User> userMap() {
        return new ConcurrentHashMap<>();
    }

    @Bean(name = "posts")
    public ConcurrentMap<String, Post> posts() {
        return new ConcurrentHashMap<>();
    }

    @Bean(name = "userPostsMapping")
    public ConcurrentMap<String, List<String>> user_posts() {
        return new ConcurrentHashMap<>();
    }

    @Bean(name = "followerFollowee")
    public ConcurrentMap<String, Set<String>> followUnfollowMap() {
        return new ConcurrentHashMap<>();
    }
}
