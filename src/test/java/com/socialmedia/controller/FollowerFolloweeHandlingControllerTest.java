package com.socialmedia.controller;

import com.socialmedia.service.impl.FollowerFolloweeHandlingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FollowerFolloweeHandlingControllerTest {

    @MockBean
    private FollowerFolloweeHandlingService followerFolloweeHandlingService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("POST /follow")
    public void followAfolloweeTest() throws Exception {

        doReturn(true).when(followerFolloweeHandlingService).follow("test1", "test2");

        mockMvc.perform(post("/follow")
                .queryParam("followerId", "test1")
                .queryParam("followeeId", "test2"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$", is("test1 followed test2")))
        ;

    }

    @Test
    @DisplayName("POST /unfollow")
    public void unfollowAfolloweeTest() throws Exception {

        doReturn(true).when(followerFolloweeHandlingService).unfollow("test1", "test2");

        mockMvc.perform(post("/unfollow")
                .queryParam("followerId", "test1")
                .queryParam("followeeId", "test2"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$", is("test1 un-followed test2")))
        ;

    }


}