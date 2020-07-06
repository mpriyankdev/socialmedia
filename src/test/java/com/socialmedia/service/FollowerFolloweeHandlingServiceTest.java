package com.socialmedia.service;

import com.socialmedia.repository.implementations.FollowerFolloweeHandlingRepository;
import com.socialmedia.service.implementations.FollowerFolloweeHandlingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ActiveProfiles("test")
class FollowerFolloweeHandlingServiceTest {

    @Autowired
    private FollowerFolloweeHandlingService followerFolloweeHandlingService;

    @MockBean
    private FollowerFolloweeHandlingRepository followerFolloweeHandlingRepository;

    @DisplayName("Check the list of followees with one follower")
    @Test
    public void checkCustomListOfFollowees() {
        Set<String> followees = new HashSet<>();
        followees.add("test1");
        followees.add("test2");

        doReturn(true).when(followerFolloweeHandlingRepository).follow("test1", "test2");
        doReturn(followees).when(followerFolloweeHandlingRepository).followees("test1");

        Assertions.assertSame(2, followerFolloweeHandlingService.followees("test1").size());

    }

    @DisplayName("follow someone")
    @Test
    public void checkCustomListOfFolloweesWithNoFollower() {


        Set<String> follow = new HashSet<>();
        follow.add("t1");
        follow.add("t2");

        doReturn(true).when(followerFolloweeHandlingRepository).follow("t1", "t2");

        Assertions.assertEquals(true, followerFolloweeHandlingService.follow("t1", "t2"));


    }

    @DisplayName("unfollow someone")
    @Test
    public void followAFollowerTest() {


        Set<String> follow = new HashSet<>();
        follow.add("t1");
        follow.add("t2");

        doReturn(true).when(followerFolloweeHandlingRepository).unfollow("t1", "t2");

        Assertions.assertEquals(true, followerFolloweeHandlingService.unfollow("t1", "t2"));

    }

    @DisplayName("Check the list of followees with no follower")
    @Test
    public void unfollowAFollowerTest() {


        Set<String> selfFollow = new HashSet<>();
        selfFollow.add("test3");

        doReturn(selfFollow).when(followerFolloweeHandlingRepository).followees("test3");
        Assertions.assertEquals(1, followerFolloweeHandlingService.followees("test3").size());

    }

}