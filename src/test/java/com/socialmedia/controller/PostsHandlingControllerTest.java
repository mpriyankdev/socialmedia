package com.socialmedia.controller;

import com.socialmedia.model.Post;
import com.socialmedia.service.impl.PostsHandlingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.OffsetDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PostsHandlingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostsHandlingService postsHandlingService;

    @DisplayName("POST /post")
    @Test
    public void testPostCreation() throws Exception {

        Post p1 = Post.builder().postId("100").postTime(OffsetDateTime.now()).content("first post").build();

        doReturn(p1).when(postsHandlingService).postCreation("test", "100", "first post");

        mockMvc.perform(MockMvcRequestBuilders.post("/post")
                .queryParam("userId", "test")
                .queryParam("postId", "100")
                .queryParam("content", "first post"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.postId", is("100")))
                .andExpect(jsonPath("$.content", is("first post")));

    }

}