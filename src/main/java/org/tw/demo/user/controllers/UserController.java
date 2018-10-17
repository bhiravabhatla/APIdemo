package org.tw.demo.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.tw.demo.user.commands.UserCommand;
import org.tw.demo.user.domains.User;
import org.tw.demo.user.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public Map<String,String> createUser(@RequestBody UserCommand userCommand){
        String  userID=UUID.randomUUID().toString();
        Map<String,String> result=new HashMap<>();
        result.put("id",userID);
        System.out.println(userCommand.getFullName());
        userRepository.save(new User(userID,userCommand.getFullName(),userCommand.getPhone()));
        return result;

    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){

        return userRepository.findByUserID(id);
    }
}
