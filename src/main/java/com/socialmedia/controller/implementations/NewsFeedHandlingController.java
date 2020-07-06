package com.socialmedia.controller.implementations;

import com.socialmedia.controller.interfaces.INewsFeedHandlingController;
import com.socialmedia.model.Post;
import com.socialmedia.service.interfaces.INewsFeedHandlingService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "topNPosts")
@RestController
@RequestMapping("/feed")
public class NewsFeedHandlingController implements INewsFeedHandlingController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private INewsFeedHandlingService newsFeedHandlingService;

    @Override
    @GetMapping
    public ResponseEntity<List<Post>> newsFeed(@RequestParam(value = "userId", required = true) final String userId, @RequestParam(value = "limit", required = true) final Integer limit) {

        final List<Post> posts = newsFeedHandlingService.topNPosts(userId, limit);
        return ResponseEntity.ok(posts);
    }
}
