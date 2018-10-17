package org.tw.demo.account.controllers;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.tw.demo.account.commands.AccountCommand;
import org.tw.demo.account.domains.Account;
import org.tw.demo.account.repositories.AccountRepository;
import org.tw.demo.user.commands.UserCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    public static final String URL ="http://localhost:6060/user/create";




    @PostMapping("/create")
    public Map<String,String> createAccount(@RequestBody AccountCommand accountCommand){

        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> response = new HashMap<>();
        UserCommand userCommand=new UserCommand(accountCommand.getFullName(),accountCommand.getPhone());
        JsonNode userResponse =  restTemplate.postForObject(URL,userCommand,JsonNode.class);
        System.out.println(userResponse.get("id").asText());
        String accountId= UUID.randomUUID().toString();

        response.put("account_id",accountId);
        response.put("user_id",userResponse.get("id").asText());
        accountRepository.save(new Account(accountId,userResponse.get("id").asText(),accountCommand.getEmail(),accountCommand.getDesc()));
        return  response;


    }

    @GetMapping("/")
    public List<Account> getAllaccounts(){
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    public Account getAccountDetails(@PathVariable String id){
       return accountRepository.findByAccountId(id);
    }
}
