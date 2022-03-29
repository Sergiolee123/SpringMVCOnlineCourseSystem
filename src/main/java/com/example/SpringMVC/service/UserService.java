package com.example.SpringMVC.service;

import com.example.SpringMVC.dao.UserRepository;
import com.example.SpringMVC.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Optional<User> findUserByUserName(String username){
        return userRepository.findById(username);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void addUser(User user){
        userRepository.save(user);
    }
}
