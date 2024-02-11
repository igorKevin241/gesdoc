package com.igor.gesdoc.controller;

import com.igor.gesdoc.entity.User;
import com.igor.gesdoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("get-all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("create")
    public User createUser(@RequestBody User user, Long activityId){
        return userService.createUser(user, activityId);
    }

    @PutMapping("{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user){
        return userService.updateUser(userId, user);
    }
    @DeleteMapping("{userId}")
    public String deleteUserById(@PathVariable Long userId){
        return userService.deleteUserById(userId);
    }
}

