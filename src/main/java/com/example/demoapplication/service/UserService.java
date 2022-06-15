package com.example.demoapplication.service;

import com.example.demoapplication.dao.UserRepository;
import com.example.demoapplication.exceptions.UserAlreadyExistException;
import com.example.demoapplication.exceptions.UserNotFoundException;
import com.example.demoapplication.exceptions.WeakPasswordException;
import com.example.demoapplication.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<UserEntity> getUserById(Long userId){
        Optional<UserEntity> user = this.userRepository.findById(userId);
        if (user == null){
            throw new UserNotFoundException("The user with id "+userId+" does not exist.");
        }
        return user;
    }

    public UserEntity addUser(UserEntity userEntity){
        if (checkifUserExist(userEntity)){
            throw new UserAlreadyExistException("This user "+userEntity+" already exists.");
        }
        if (!checkPassword(userEntity.getPassword())){
            throw new WeakPasswordException("The password must be at least 8 character, have digits and letters.");
        }
        UserEntity user = userRepository.save(userEntity);

        return user;
    }
    private boolean checkifUserExist(UserEntity userEntity){
        for (UserEntity user: userRepository.findAll()){
            if (user.getEmail().equals(userEntity.getEmail())){
                return true;
            }
        }
        return false;
    }
    private boolean checkPassword(String password){
        if (password.length() < 8){
            return false;
        }
        boolean isDigit = false;
        boolean isLetter = false;

        for (int i=0; i<password.length(); i++){
            if (Character.isLetter(password.charAt(i))){
                isLetter = true;
            }
            if (Character.isDigit(password.charAt(i))){
                isDigit = true;
            }
        }
        return isDigit && isLetter;
    }
}
