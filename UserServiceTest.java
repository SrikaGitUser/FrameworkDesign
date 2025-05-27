package com.example.service;

import com.example.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setName("Leanne Graham");
        mockUser.setEmail("leanne@example.com");

        String url = "https://jsonplaceholder.typicode.com/users/1";
        when(restTemplate.getForObject(url, User.class)).thenReturn(mockUser);

        User user = userService.getUserById(1);

        assertNotNull(user);
        assertEquals("Leanne Graham", user.getName());
        verify(restTemplate).getForObject(url, User.class);
    }
}