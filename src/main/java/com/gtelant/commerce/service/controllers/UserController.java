package com.gtelant.commerce.service.controllers;

import com.gtelant.commerce.service.models.User;
import com.gtelant.commerce.service.repositories.UserRepository;
import com.gtelant.commerce.service.responses.UserRequest;
import com.gtelant.commerce.service.responses.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")

public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository =userRepository;
    }

    @Operation
    @PostMapping
    public ResponseEntity<UserRequest> createUser(@RequestBody UserRequest request){
        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBirthday(request.getBirthday());
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        user.setCity(request.getCity());
        user.setZipcode(request.getZipcode());
        user.setPassword(request.getPassword());
        user.setHasNewsletter(request.isHasNewsletter());
        user.setCreatedAt(LocalDateTime.now());
        user.setRole("ROLE_USER");

        User saveUser = userRepository.save(user);
        UserRequest response = new UserRequest(
                saveUser.getFirstName(),
                saveUser.getLastName(),
                saveUser.getBirthday(),
                saveUser.getEmail(),
                saveUser.getAddress(),
                saveUser.getCity(),
                saveUser.getZipcode(),
                saveUser.getPassword(),
                saveUser.isHasNewsletter()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<User> users =userRepository.findAll();
        return ResponseEntity.ok(users.stream().map(UserResponse::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            UserResponse response = new UserResponse(user.get());
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUserById(@PathVariable int id, @RequestBody UserRequest request){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User updateUser = user.get();

            updateUser.setFirstName(request.getFirstName());
            updateUser.setLastName(request.getLastName());
            updateUser.setBirthday(request.getBirthday());
            updateUser.setEmail(request.getEmail());
            updateUser.setLastSeenAt(LocalDateTime.now());
            updateUser.setHasNewsletter(request.isHasNewsletter());

            updateUser = userRepository.save(updateUser);
            UserResponse response = new UserResponse(
                    updateUser.getId(),
                    updateUser.getFirstName(),
                    updateUser.getLastName(),
                    updateUser.getBirthday(),
                    updateUser.getLastSeenAt(),
                    updateUser.isHasNewsletter(),
                    updateUser.getUserSegments()
            );
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.delete(user.get());
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
