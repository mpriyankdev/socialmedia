package com.socialmedia.controller.interfaces;

import com.socialmedia.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface INewsFeedHandlingController {
    @GetMapping
    ResponseEntity<List<Post>> newsFeed(@RequestParam(value = "userId", required = true) String userId, @RequestParam(value = "limit", required = true) Integer limit);
}
