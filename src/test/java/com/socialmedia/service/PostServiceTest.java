/*
package com.socialmedia.service;

import com.socialmedia.model.Post;
import com.socialmedia.repository.impl.PostsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.OffsetDateTime;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @MockBean
    private PostsRepository postsRepository;

    @DisplayName("Create Post")
    @Test
    void createPostTest() {
        Post testPost = Post.builder().postId("100").postTime(OffsetDateTime.MAX).content("test").build();
        doReturn(testPost).when(postsRepository).createPost(testPost);
        Assertions.assertEquals("100", postService.createPost(testPost).getPostId());
    }

    @DisplayName("Update Post")
    @Test
    void updatePostTest() {
        Post testPost = Post.builder().postId("100").postTime(OffsetDateTime.MAX).content("test").build();
        doReturn(testPost).when(postsRepository).createPost(testPost);
        Assertions.assertEquals("100", postService.createPost(testPost).getPostId());
    }

    @DisplayName("Fetch Post")
    @Test
    void fetchUserTest() {
        Post testPost = Post.builder().postId("100").postTime(OffsetDateTime.MAX).content("test").build();
        doReturn(testPost).when(postsRepository).createPost(testPost);
        doReturn(testPost).when(postsRepository).fetchPost("100");

        Assertions.assertEquals("100", postService.fetchPost("100").getPostId());
    }

    @DisplayName("Delete Post")
    @Test
    void deleteUserTest() {
        Post testPost = Post.builder().postId("100").postTime(OffsetDateTime.MAX).content("test").build();
        doReturn(testPost).when(postsRepository).createPost(testPost);
        doReturn(true).when(postsRepository).deletePost("100");
        Assertions.assertEquals(true, postService.deletePost("100"));
    }


}*/
