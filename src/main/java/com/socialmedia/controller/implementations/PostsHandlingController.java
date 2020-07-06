package com.socialmedia.controller.implementations;

import com.socialmedia.controller.interfaces.IPostsHandlingController;
import com.socialmedia.model.Post;
import com.socialmedia.service.interfaces.IPostsHandlingService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@Api(value = "createPost")
@RestController
@RequestMapping("/post")
public class PostsHandlingController implements IPostsHandlingController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private IPostsHandlingService postsHandlingService;

    @Override
    @PostMapping
    public ResponseEntity<Post> handlePost(@RequestParam(value = "userId", required = true) final String userId,
                                           @RequestParam(value = "postId", required = true) final String postId,
                                           @RequestParam(value = "content", required = true) final String postContent) throws URISyntaxException {
        final Post post = postsHandlingService.postCreation(userId, postId, postContent);
        if (post != null) {
            return ResponseEntity.created(new URI("/post/" + post.getPostId())).body(post);
        }
        return ResponseEntity.badRequest().build();

    }


}
