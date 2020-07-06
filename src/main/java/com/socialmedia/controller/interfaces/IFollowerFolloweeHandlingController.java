package com.socialmedia.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IFollowerFolloweeHandlingController {
    @PostMapping("/follow")
    ResponseEntity<String> follow(@RequestParam(value = "followerId", required = true) String followerId, @RequestParam(value = "followeeId", required = true) String followeeId);

    @PostMapping("/unfollow")
    ResponseEntity<String> unfollow(@RequestParam(value = "followerId", required = true) String followerId, @RequestParam(value = "followeeId", required = true) String followeeId);
}
