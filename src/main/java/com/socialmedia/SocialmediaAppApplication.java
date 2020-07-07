package com.socialmedia;

import com.socialmedia.model.User;
import com.socialmedia.service.impl.FollowerFolloweeHandlingService;
import com.socialmedia.service.impl.NewsFeedHandlingService;
import com.socialmedia.service.impl.PostsHandlingService;
import com.socialmedia.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialmediaAppApplication implements CommandLineRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private UserService userService;

    @Autowired
    private FollowerFolloweeHandlingService followerFolloweeHandlingService;
    @Autowired
    private PostsHandlingService postsHandlingService;
    @Autowired
    private NewsFeedHandlingService newsFeedHandlingService;

    @Value("${custom.test}")
    private Boolean runTest;

    public static void main(String[] args) {
        SpringApplication.run(SocialmediaAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (runTest) {


            LOGGER.info("\n\n******************STARTING APPLICATION TEST ************************************\n\n");

            LOGGER.info("\n\nCreating Dummy Users : priyank ,sachin, shivangi and virat\n");
            userService.createUser(User.builder().userId("priyank").userName("priyank maheshwari").build());
            userService.createUser(User.builder().userId("shivangi").userName("shivangi maheshwari").build());
            userService.createUser(User.builder().userId("sachin").userName("sachin tendulkar").build());
            userService.createUser(User.builder().userId("virat").userName("virat kohli").build());

            LOGGER.info("\n\nPosting dummy posts on behalf of the users created\n");
            postsHandlingService.postCreation("priyank", "1", "hello world from priyank");
            postsHandlingService.postCreation("priyank", "2", "hello world again from priyank");
            postsHandlingService.postCreation("priyank", "3", "Amigos!! --priyank");
            Thread.sleep(1000);
            postsHandlingService.postCreation("shivangi", "4", "hello world from shivangi");
            Thread.sleep(1000);
            postsHandlingService.postCreation("shivangi", "5", "hello world again from shivangi");
            Thread.sleep(1000);
            postsHandlingService.postCreation("shivangi", "6", "hello world again from shivangiiiii");

            postsHandlingService.postCreation("sachin", "10", "Hello from Sachin");
            Thread.sleep(1000);
            postsHandlingService.postCreation("sachin", "11", "This is master blaster!!");
            postsHandlingService.postCreation("sachin", "12", "hello world!! today i am retiring");

            postsHandlingService.postCreation("virat", "13", "first post from virat kohliii");


            LOGGER.info("\n\n******************ENDING APPLICATION TEST ************************************\n\n");
        }
    }
}
