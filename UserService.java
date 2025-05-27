package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
//    RestTemplate restTemplate;
    public User getUserById(int id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id;
//        System.out.println(restTemplate.getForObject(url, User.class).toString());
        return restTemplate.getForObject(url, User.class);
    }
}