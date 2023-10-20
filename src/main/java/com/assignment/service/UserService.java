package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.User;
import com.assignment.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserByCommentFrom(String commentFrom) {
        return userRepository.findByCommentFrom(commentFrom);
    }
    
    public User getUserByCommentTo(String commentTo) {
        return userRepository.findByCommentTo(commentTo);
    }

}

