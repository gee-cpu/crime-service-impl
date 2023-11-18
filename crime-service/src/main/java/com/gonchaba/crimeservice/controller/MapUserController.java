package com.gonchaba.crimeservice.controller;

import com.gonchaba.crimeservice.dto.MapUserDTO;
import com.gonchaba.crimeservice.model.MapUser;
import com.gonchaba.crimeservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MapUserController {

    private final UserService userService;

    public MapUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<MapUser> getUserById(@PathVariable Long userId) {
        MapUser user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<MapUser>> getAllUsers() {
        List<MapUser> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MapUser> createUser(@RequestBody MapUserDTO userDto) {
        MapUser createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String userName, @RequestParam String password) {
        boolean loginStatus = userService.loginUser(userName, password);
        if (loginStatus) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<MapUser> updateUser(@PathVariable Long userId, @RequestBody MapUserDTO userDto) {
        MapUser updatedUser = userService.updateUser(userId, userDto);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
