package com.socialmedia.service;


import com.socialmedia.model.Post;
import com.socialmedia.repository.implementations.UserPostsHandlingRepository;
import com.socialmedia.service.implementations.FollowerFolloweeHandlingService;
import com.socialmedia.service.implementations.NewsFeedHandlingService;
import com.socialmedia.service.implementations.PostsHandlingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ActiveProfiles("test")
class NewsFeedHandlingServiceTest {

    @Autowired
    private NewsFeedHandlingService newsFeedHandlingService;

    @MockBean
    private UserPostsHandlingRepository userPostsHandlingRepository;

    @Mock
    private PostsHandlingService postsHandlingService;

    @Mock
    private FollowerFolloweeHandlingService followerFolloweeHandlingService;


    @DisplayName("topNPosts for a user")
    @Test
    @Disabled
    public void topNPostsForAUserTest() {

        List<String> followees = Arrays.asList("test1", "test2");
        Post p1 = Post.builder().postId("100").postTime(OffsetDateTime.now()).content("test post").build();
        Set<String> followeesSet = new HashSet<>();
        followeesSet.add("test1");
        followeesSet.add("test2");


        doReturn(followees).when(userPostsHandlingRepository).fetchUserToPostsMapping("test1");
        doReturn(true).when(userPostsHandlingRepository).isUserHasAnyPosts("test1");


        doReturn(p1).when(postsHandlingService).fetchPosts("100");
        doReturn(followeesSet).when(followerFolloweeHandlingService).followees("test1");

        Assertions.assertEquals(1, newsFeedHandlingService.topNPosts("test1", 10).size());


    }


}