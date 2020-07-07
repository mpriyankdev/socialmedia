package com.socialmedia.controller;

import com.socialmedia.service.IFollowerFolloweeHandlingService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "follow-followee")
@RestController
public class FollowerFolloweeHandlingController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Autowired
    private IFollowerFolloweeHandlingService followerFolloweeHandlingService;


    @PostMapping("/follow")
    public ResponseEntity<String> follow(@RequestParam(value = "followerId", required = true) final String followerId, @RequestParam(value = "followeeId", required = true) final String followeeId) {

        followerFolloweeHandlingService.follow(followerId, followeeId);
        LOGGER.info("{} followed celebrity {}", followerId, followeeId);
        return ResponseEntity.accepted().body(followerId.concat(" followed ").concat(followeeId));
    }


    @PostMapping("/unfollow")
    public ResponseEntity<String> unfollow(@RequestParam(value = "followerId", required = true) final String followerId, @RequestParam(value = "followeeId", required = true) final String followeeId) {
        followerFolloweeHandlingService.unfollow(followerId, followeeId);
        LOGGER.info("{} unfollowed celebrity {}", followerId, followeeId);
        return ResponseEntity.accepted().body(followerId.concat(" un-followed ").concat(followeeId));
    }
}
