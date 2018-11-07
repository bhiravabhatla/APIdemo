package org.tw.demo.user.controllers;

import org.springframework.web.bind.annotation.*;
import org.tw.demo.user.commands.UserCommand;
import org.tw.demo.user.domains.User;
import org.tw.demo.user.services.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public Map<String,String> createUser(@RequestBody UserCommand userCommand){
        return userService.createUser(userCommand);

    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){

        return userService.getUserById(id);
    }
}
