package com.socialmedia.controller;

import com.socialmedia.model.Post;
import com.socialmedia.service.implementations.NewsFeedHandlingService;
import com.socialmedia.service.interfaces.INewsFeedHandlingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class NewsFeedHandlingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsFeedHandlingService newsFeedHandlingService;


    @DisplayName("GET /feed")
    @Test
    void topNPostsTest() throws Exception {

        Comparator<Post> postComparator = Comparator.comparing(Post::getPostTime).reversed();

        Post p1 = Post.builder().postId("1").content("hello world!!").postTime(OffsetDateTime.now().plusHours(1)).build();
        Post p2 = Post.builder().postId("2").content("hola!!").postTime(OffsetDateTime.now().minusHours(5)).build();
        Post p3 = Post.builder().postId("3").content("amigos!!").postTime(OffsetDateTime.now().plusHours(3)).build();

        final List<Post> collect = Arrays.asList(p1, p2, p3).stream().sorted(postComparator).collect(Collectors.toList());


        doReturn(collect).when(newsFeedHandlingService).topNPosts("test", 3);

        mockMvc.perform(get("/feed")
                .queryParam("userId", "test")
                .queryParam("limit", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].postId", is("3")))  //posts sequence based on the posting time
                .andExpect(jsonPath("$[1].postId", is("1")))
                .andExpect(jsonPath("$[2].postId", is("2")));

    }
}