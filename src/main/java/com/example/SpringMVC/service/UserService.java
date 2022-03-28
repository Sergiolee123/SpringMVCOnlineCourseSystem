package com.example.SpringMVC.service;

import com.example.SpringMVC.dao.UserRepository;
import com.example.SpringMVC.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUserName(String username){
        return userRepository.findById(username).orElse(null);
    }

    @Transactional(rollbackFor = Throwable.class)
    public User addUser(User user){
        return userRepository.save(user);
    }
}
