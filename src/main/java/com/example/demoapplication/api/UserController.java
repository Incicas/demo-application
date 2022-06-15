package com.example.demoapplication.api;

import com.example.demoapplication.model.UserEntity;
import com.example.demoapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers(){
        List<UserEntity> users =  this.userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable Long userId){
        Optional<UserEntity> user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity){
        UserEntity user = userService.addUser(userEntity);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
