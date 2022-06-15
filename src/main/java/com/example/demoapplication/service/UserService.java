package com.example.demoapplication.service;

import com.example.demoapplication.dao.UserRepository;
import com.example.demoapplication.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUsers(){
        return this.userRepository.findAll();
    }

}
