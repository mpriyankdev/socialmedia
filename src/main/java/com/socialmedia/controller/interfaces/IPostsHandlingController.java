package com.socialmedia.controller.interfaces;

import com.socialmedia.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URISyntaxException;

public interface IPostsHandlingController {
    @PostMapping
    ResponseEntity<Post> handlePost(@RequestParam(value = "userId", required = true) String userId,
                                    @RequestParam(value = "postId", required = true) String postId,
                                    @RequestParam(value = "content", required = true) String postContent) throws URISyntaxException;
}
