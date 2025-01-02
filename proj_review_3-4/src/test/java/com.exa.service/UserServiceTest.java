package com.exa.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import UserDao;
import User;
import UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserDao userDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userDao);
    }

    @Test
    public void testRegisterUser() {
        User user = new User("John Doe");
        when(userDao.save(user)).thenReturn(true);

        boolean result = userService.registerUser(user);

        assertTrue(result, "User should be registered successfully.");
        verify(userDao, times(1)).save(user);
    }

    @Test
    public void testRegisterUserFailure() {
        User user = new User("John Doe");
        when(userDao.save(user)).thenReturn(false);

        boolean result = userService.registerUser(user);

        assertFalse(result, "User registration should fail.");
        verify(userDao, times(1)).save(user);
    }
}
