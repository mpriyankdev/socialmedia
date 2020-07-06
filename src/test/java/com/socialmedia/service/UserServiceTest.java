package com.socialmedia.service;

import com.socialmedia.model.User;
import com.socialmedia.repository.implementations.UsersRepository;
import com.socialmedia.service.implementations.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UsersRepository usersRepository;

    @DisplayName("Create User")
    @Test
    void createUserTest() {
        User testUser = User.builder().userId("test").userName("test user for jUnit").build();
        doReturn(testUser).when(usersRepository).createUser(testUser);
        Assertions.assertEquals("test", userService.createUser(testUser).getUserId());
    }

    @DisplayName("Fetch User")
    @Test
    void fetchUserTest() {
        User testUser = User.builder().userId("test").userName("test user for jUnit").build();
        doReturn(testUser).when(usersRepository).createUser(testUser);
        doReturn(testUser).when(usersRepository).fetchUser("test");

        Assertions.assertEquals("test", userService.fetchUser("test").getUserId());
    }

    @DisplayName("Delete User")
    @Test
    void deleteUserTest() {
        User testUser = User.builder().userId("test").userName("test user for jUnit").build();
        doReturn(testUser).when(usersRepository).createUser(testUser);
        doReturn(true).when(usersRepository).deleteUser("test");
        Assertions.assertEquals(true, userService.deleteUser("test"));
    }

    @DisplayName("Check if User exists")
    @Test
    void checkIfUserExistsTest() {
        User testUser = User.builder().userId("test").userName("test user for jUnit").build();
        doReturn(testUser).when(usersRepository).createUser(testUser);
        doReturn(true).when(usersRepository).exists("test");
        Assertions.assertEquals(true, userService.exists("test"));
    }

    @DisplayName("Check if User do not exists")
    @Test
    void checkIfUserDontExistsTest() {
        User testUser = User.builder().userId("test").userName("test user for jUnit").build();
        doReturn(testUser).when(usersRepository).createUser(testUser);
        doReturn(false).when(usersRepository).exists("test2");
        Assertions.assertEquals(false, userService.exists("test2"));
    }


}