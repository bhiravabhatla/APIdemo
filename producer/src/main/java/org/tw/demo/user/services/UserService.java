package org.tw.demo.user.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.tw.demo.user.commands.UserCommand;
import org.tw.demo.user.domains.User;
import org.tw.demo.user.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, String> createUser(@RequestBody UserCommand userCommand) {
        String  userID= UUID.randomUUID().toString();
        Map<String,String> result=new HashMap<>();
        result.put("id",userID);
        userRepository.save(new User(userID,userCommand.getFullName(),userCommand.getPhone()));
        return result;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findByUserID(id);
    }
}
