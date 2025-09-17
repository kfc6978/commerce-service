package com.gtelant.commerce.service.controllers;

import com.gtelant.commerce.service.dtos.UserRequest;
import com.gtelant.commerce.service.dtos.UserResponse;
import com.gtelant.commerce.service.mappers.UserMapper;
import com.gtelant.commerce.service.models.User;
import com.gtelant.commerce.service.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")

public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Operation
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(userMapper.toUserResponse(createdUser));
    }


    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers().stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id){
        User user = userService.getUserById(id);
        if (user == null){
        return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(userMapper.toUserResponse(user));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUserById(@PathVariable int id, @RequestBody UserRequest userRequest){
        User user = userMapper.toUser(userRequest);
        User updateUser = userService.updateUser(id, user);
        if (user == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(userMapper.toUserResponse(updateUser));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
