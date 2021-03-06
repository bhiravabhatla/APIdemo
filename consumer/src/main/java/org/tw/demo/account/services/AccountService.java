package org.tw.demo.account.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tw.demo.account.commands.AccountCommand;
import org.tw.demo.account.domains.Account;
import org.tw.demo.account.repositories.AccountRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    public static final String URL ="http://localhost:6050/user/create";

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Map<String,String> createAccount(AccountCommand accountCommand){

        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> response = new HashMap<>();
        Map<String,String> request_body = new HashMap<>();

        request_body.put("fullName",accountCommand.getFullName());
        request_body.put("phone",accountCommand.getPhone());

        //UserCommand userCommand=new UserCommand(accountCommand.getFullName(),accountCommand.getPhone());
        String accountId= UUID.randomUUID().toString();

        JsonNode userResponse =  restTemplate.postForObject(URL,request_body,JsonNode.class);


        response.put("account_id",accountId);
        response.put("user_id",userResponse.get("id").asText());
        accountRepository.save(new Account(accountId,userResponse.get("id").asText(),accountCommand.getDesc(),accountCommand.getEmail()));
        return response;
    }

    public List<Account> getAllaccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountDetails(String id){
        return accountRepository.findByAccountId(id);
    }

}
