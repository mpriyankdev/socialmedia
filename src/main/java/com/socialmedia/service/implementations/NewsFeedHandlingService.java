package com.socialmedia.service.implementations;

import com.socialmedia.model.Post;
import com.socialmedia.repository.interfaces.IUserPostsHandlingRepository;
import com.socialmedia.service.interfaces.IFollowerFolloweeHandlingService;
import com.socialmedia.service.interfaces.INewsFeedHandlingService;
import com.socialmedia.service.interfaces.IPostsHandlingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsFeedHandlingService implements INewsFeedHandlingService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private IFollowerFolloweeHandlingService followerFolloweeHandlingService;
    @Autowired
    private IPostsHandlingService postsHandlingService;
    @Autowired
    private IUserPostsHandlingRepository userPostsHandlingRepository;


    @Override
    public List<Post> topNPosts(final String userId, final Integer numberOfPosts) {

        Comparator<Post> postComparator = Comparator.comparing(Post::getPostTime).reversed();

        //get all followees
        //fetch all posts from them
        //sort by time and then return topN

        //contains all the postIds for the user followers
        final List<String> followeesIdWhoHasAtleastOnePost = followees(userId).stream()
                .filter(x -> userPostsHandlingRepository.isUserHasAnyPosts(x))
                .map(x -> userPostsHandlingRepository.fetchUserToPostsMapping(x))
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        final List<Post> topNPosts = followeesIdWhoHasAtleastOnePost.stream().map(postId -> postsHandlingService.fetchPosts(postId))
                .sorted(postComparator).limit(numberOfPosts)
                .collect(Collectors.toList());
        return topNPosts;


    }


    private List<String> followees(final String userId) {
        final List<String> collect = followerFolloweeHandlingService.followees(userId).stream().collect(Collectors.toList());
        return collect;
    }


}
