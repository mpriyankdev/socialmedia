package com.socialmedia.service;

import com.socialmedia.model.Post;
import com.socialmedia.repository.implementations.PostsRepository;
import com.socialmedia.repository.implementations.UsersRepository;
import com.socialmedia.service.implementations.PostsHandlingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.OffsetDateTime;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ActiveProfiles("test")
class PostsHandlingServiceTest {

    @MockBean
    private PostsRepository postsRepository;

    @MockBean
    private UsersRepository usersRepository;

    @Autowired
    private PostsHandlingService postsHandlingService;

    @BeforeEach
    void setUp() {
        Post p1 = Post.builder().postId("100").postTime(OffsetDateTime.now().plusHours(2)).content("test content 1").build();
        Post p2 = Post.builder().postId("101").postTime(OffsetDateTime.now().plusHours(1)).content("test content 2").build();


        doReturn(p1).when(postsRepository).createPost(p1);
        doReturn(p2).when(postsRepository).createPost(p2);

        doReturn(p1).when(postsRepository).fetchPost("100");
        doReturn(p2).when(postsRepository).fetchPost("101");

        doReturn(true).when(postsRepository).deletePost("100");
        doReturn(true).when(postsRepository).deletePost("101");


    }

    @Test
    @DisplayName("Post Creation")
    @Disabled
    public void postCreationTest() {

        doReturn(true).when(usersRepository).exists("test");




    }

}